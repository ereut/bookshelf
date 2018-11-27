package com.gmail.reut0488.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.reut0488.transfer.IFullDetails;
import com.gmail.reut0488.transfer.INewable;
import com.gmail.reut0488.transfer.IUpdateable;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book implements IEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "booksSequenceGenerator", allocationSize = 1, sequenceName = "books_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booksSequenceGenerator")
    @Null(groups = {INewable.class})
    @NotNull(groups = {IUpdateable.class})
    private Long id;
    @Column(name = "title")
    @NotNull(groups = {INewable.class, IUpdateable.class})
    @JsonView(IFullDetails.class)
    private String title;

    @JsonView(IFullDetails.class)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authorsSet;

}

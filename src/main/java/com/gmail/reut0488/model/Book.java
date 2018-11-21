package com.gmail.reut0488.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements IEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "booksSequenceGenerator", allocationSize = 1, sequenceName = "booksSequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booksSequenceGenerator" )
    private Long id;
    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authorsSet;





}

package com.gmail.reut0488.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.reut0488.transfer.IFullDetails;
import com.gmail.reut0488.transfer.INewable;
import com.gmail.reut0488.transfer.IUpdateable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "authors")
@Data
public class Author implements IEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(groups = INewable.class)
    @NotNull(groups = IUpdateable.class)
    @JsonView(IFullDetails.class)
    private Long id;

    @Column(name = "first_name")
    @Setter
    @NotNull(groups = {INewable.class, IUpdateable.class})
    @JsonView(IFullDetails.class)
    private String firstName;

    @Column(name = "last_name")
    @Setter
    @NotNull(groups = {INewable.class, IUpdateable.class})
    @JsonView(IFullDetails.class)
    private String lastName;

}

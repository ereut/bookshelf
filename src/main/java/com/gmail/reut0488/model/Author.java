package com.gmail.reut0488.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Author implements IEntity {

    public Author(String firstName, String lastName) {
        this(null, firstName, lastName);
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Setter
    private String lastName;

}

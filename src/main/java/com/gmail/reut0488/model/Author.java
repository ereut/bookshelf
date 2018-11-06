package com.gmail.reut0488.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Author implements IEntity {

    private static final String BIRTH_DATE_PATTERN = "dd.MM.yyyy";

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

    @Column(name = "birth_date")
    @Setter
    private Date birthDate;

    public Author(String firstName, String lastName, Date birthDate) {
        this(null, firstName, lastName, birthDate);
    }

}

package com.gmail.reut0488.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

//@Entity
//@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements IEntity {

    private Long id;
    private String title;
    private List<Author> authorsList;
    private Date publishingYear;

}

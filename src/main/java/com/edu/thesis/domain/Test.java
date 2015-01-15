package com.edu.thesis.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Oleg on 12.01.2015.
 */
@Entity
@Table(name = "test")//http://stackoverflow.com/questions/5763747/h2-in-memory-database-table-not-found
public class Test implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String col1;

    private String col2;

    public Test() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}

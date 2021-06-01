package com.stranglemoon.stranglemoon.model;

import javax.persistence.*;

@Entity
@Table(name= "construction_instance")
public class ConstructionInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actual_rank")
    private int actualRank;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="account_id",referencedColumnName="id",nullable=false)
    private Account account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getActualRank() {
        return actualRank;
    }

    public void setActualRank(int actualRank) {
        this.actualRank = actualRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

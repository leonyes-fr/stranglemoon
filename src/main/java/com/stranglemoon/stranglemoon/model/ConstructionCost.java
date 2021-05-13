package com.stranglemoon.stranglemoon.model;

import javax.persistence.*;

@Entity
@Table(name = "construction_cost")
public class ConstructionCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rank;

    private int tavern;

    private int laboratory;

    private int farm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTavern() {
        return tavern;
    }

    public void setTavern(int tavern) {
        this.tavern = tavern;
    }

    public int getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(int laboratory) {
        this.laboratory = laboratory;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }
}

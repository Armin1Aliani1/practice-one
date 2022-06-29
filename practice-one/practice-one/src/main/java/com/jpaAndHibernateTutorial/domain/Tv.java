package com.jpaAndHibernateTutorial.domain;

import javax.persistence.Entity;

@Entity
public class Tv extends Electronic {
    private Integer inch;

    public Integer getInch() {
        return inch;
    }

    public void setInch(Integer inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "Tv{" +
                super.toString() + " , " +
                "inch=" + inch +
                '}';
    }
}

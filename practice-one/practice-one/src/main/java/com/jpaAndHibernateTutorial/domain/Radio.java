package com.jpaAndHibernateTutorial.domain;

import javax.persistence.Entity;

@Entity
public class Radio extends Electronic {
    private Integer frequency;

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Radio{" +
                super.toString() + " , " +
                "frequency=" + frequency +
                '}';
    }
}

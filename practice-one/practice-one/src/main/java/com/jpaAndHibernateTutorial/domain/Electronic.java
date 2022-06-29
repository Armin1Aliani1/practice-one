package com.jpaAndHibernateTutorial.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Electronic extends Product {
    private Long power;

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                super.toString() + "," +
                "power=" + power +
                '}';
    }
}

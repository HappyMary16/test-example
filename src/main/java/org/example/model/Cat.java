package org.example.model;

import java.time.Instant;
import java.util.Objects;

public class Cat {

    private String name;
    private CatBehaviour behaviour;
    private Instant birthday;

    public Cat() {
    }

    public Cat(String name, CatBehaviour behaviour) {
        this.name = name;
        this.behaviour = behaviour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBehaviour(CatBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public CatBehaviour getBehaviour() {
        return behaviour;
    }

    public Instant getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Cat cat)) return false;
        return Objects.equals(getName(),
                              cat.getName()) && getBehaviour() == cat.getBehaviour() && Objects.equals(
                getBirthday(), cat.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBehaviour(), getBirthday());
    }
}

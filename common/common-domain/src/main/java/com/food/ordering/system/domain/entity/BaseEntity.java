package com.food.ordering.system.domain.entity;

import java.util.Objects;


/**
 * @author Enis Halilaj
 * @param <ID>
 * BaseEntity is the base class for all entities in the domain model.
 * It provides an ID field and equals and hashCode methods.
 * It is abstract because it is not intended to be instantiated.
 * It is intended to be extended by concrete entity classes.
 */

public abstract class BaseEntity<ID> {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

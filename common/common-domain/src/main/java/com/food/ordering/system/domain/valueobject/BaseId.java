package com.food.ordering.system.domain.valueobject;

import java.util.Objects;

/**
 * @author Enis Halilaj
 * @param <T>
 * BaseId is the base class for all value objects that represent an ID.
 * It provides a value field and equals and hashCode methods.
 * It is abstract because it is not intended to be instantiated.
 * It is intended to be extended by concrete ID classes.
 */

public abstract class BaseId<T> {

    private final T value;

    protected BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseId<?> baseId = (BaseId<?>) o;

        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

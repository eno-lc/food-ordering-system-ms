package com.food.ordering.system.domain.entity;


/**
 * @author Enis Halilaj
 * @param <ID>
 * AggregateRoot is the base class for all aggregate roots in the domain model.
 * It is abstract because it is not intended to be instantiated.
 * It is intended to be extended by concrete aggregate root classes.
 * It extends BaseEntity.
 * It is a marker class.
 * A marker class is a class that has no methods or fields, but is used to identify a particular type.
 * In this case, it is used to identify aggregate roots.
 */

public abstract class AggregateRoot<ID> extends BaseEntity<ID>{
}

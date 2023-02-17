package com.food.ordering.system.domain.event;

/**
 * @author Enis Halilaj
 * @param <T>
 * DomainEvent is an interface that represents a domain event.
 * It will mark an event object with the type of entity that will fire that event.
 * For example, when we create a class OrderCreatedEvent, we will set the generic type as Order which is the entity that this event is originated from.
 */
public interface DomainEvent<T>{
}

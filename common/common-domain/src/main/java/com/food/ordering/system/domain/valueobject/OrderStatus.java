package com.food.ordering.system.domain.valueobject;


/**
 * @author Enis Halilaj
 * OrderStatus is a value object that represents an order status.
 * Uses enum to represent order status.
 * It has 5 possible values: PENDING, PAID, APPROVED, CANCELLING, CANCELLED.
 */
public enum OrderStatus {
    PENDING, PAID, APPROVED, CANCELLING, CANCELLED
}

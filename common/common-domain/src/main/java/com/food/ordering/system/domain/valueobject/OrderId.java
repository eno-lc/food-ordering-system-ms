package com.food.ordering.system.domain.valueobject;

import java.util.UUID;

/**
 * @author Enis Halilaj
 * OrderId is a value object that represents an order ID.
 * It extends BaseId.
 * Uses super constructor to set value.
 * Uses UUID to generate a random value and use it as an ID.
 */

public class OrderId extends BaseId<UUID>{

    public OrderId(UUID value) {
        super(value);
    }
}

package com.food.ordering.system.domain.valueobject;

import java.util.UUID;


/**
 * @author Enis Halilaj
 * CustomerId is a value object that represents a customer ID.
 * It extends BaseId.
 * Uses super constructor to set value.
 * Uses UUID to generate a random value and use it as an ID.
 */
public class CustomerId extends BaseId<UUID>{
    public CustomerId(UUID value) {
        super(value);
    }
}

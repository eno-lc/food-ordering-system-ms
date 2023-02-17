package com.food.ordering.system.domain.valueobject;

import java.util.UUID;


/**
 * @author Enis Halilaj
 * RestaurantId is a value object that represents a restaurant ID.
 * It extends BaseId.
 * Uses super constructor to set value.
 * Uses UUID to generate a random value and use it as an ID.
 */
public class RestaurantId extends BaseId<UUID>{
    public RestaurantId(UUID value) {
        super(value);
    }
}

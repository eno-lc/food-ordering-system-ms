package com.food.ordering.system.domain.valueobject;

import java.util.UUID;

/**
 * @author Enis Halilaj
 * ProductId is a value object that represents a product ID.
 * It extends BaseId.
 * Uses super constructor to set value.
 * Uses UUID to generate a random value and use it as an ID.
 */

public class ProductId extends BaseId<UUID>{
    public ProductId(UUID value) {
        super(value);
    }
}

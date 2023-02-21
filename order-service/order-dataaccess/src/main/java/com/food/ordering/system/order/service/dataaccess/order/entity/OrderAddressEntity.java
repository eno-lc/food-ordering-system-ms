package com.food.ordering.system.order.service.dataaccess.order.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Enis Halilaj
 * @OneToOne means that this entity is the owner of the relationship, and the relationship is mapped by the address field in the OrderEntity class.
 * @JoinColumn(name = "order_id") means that the column name in the database table that stores the foreign key is order_id.
 * CascadeType.ALL means that if an order is deleted, then the order address will also be deleted.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_address")
public class OrderAddressEntity {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;
    private String street;
    private String postalCode;
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderAddressEntity that = (OrderAddressEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

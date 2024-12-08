package com.cosmeticsellingwebsite.payload.response;


import com.cosmeticsellingwebsite.entity.OrderLine;
import com.cosmeticsellingwebsite.entity.ShippingAddress;
import com.cosmeticsellingwebsite.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ShippingOrderResponse {
    private Long orderId;
    private Double total;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private ShippingAddress shippingAddress;
}

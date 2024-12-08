package com.cosmeticsellingwebsite.entity;

import com.cosmeticsellingwebsite.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderStatusHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderStatusHistoryId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime updateAt=LocalDateTime.now();
    private String description;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;
}

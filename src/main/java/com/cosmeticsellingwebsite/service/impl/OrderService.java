package com.cosmeticsellingwebsite.service.impl;

import com.cosmeticsellingwebsite.entity.Order;
import com.cosmeticsellingwebsite.entity.OrderStatusHistory;
import com.cosmeticsellingwebsite.enums.OrderStatus;
import com.cosmeticsellingwebsite.enums.PaymentMethod;
import com.cosmeticsellingwebsite.enums.PaymentStatus;
import com.cosmeticsellingwebsite.payload.response.ShippingOrderResponse;
import com.cosmeticsellingwebsite.repository.OrderRepository;
import com.cosmeticsellingwebsite.service.interfaces.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
//    public List<ShippingOrderResponse> getShippingOrderList() {
//        return orderRepository.findAll().stream().map(order -> {
//            ShippingOrderResponse shippingOrderResponse = new ShippingOrderResponse();
//            BeanUtils.copyProperties(order, shippingOrderResponse);
//            return shippingOrderResponse;
//        }).toList();
//    }
public List<ShippingOrderResponse> getShippingOrderListWithPage(Pageable pageable) {
    return orderRepository.findAllWithPaging(pageable).stream().map(order -> {
        ShippingOrderResponse shippingOrderResponse = new ShippingOrderResponse();
        BeanUtils.copyProperties(order, shippingOrderResponse);
        return shippingOrderResponse;
    }).toList();
}

    public void updateOrderComplete(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(OrderStatus.COMPLETED);
        order.setDeliveryDate(LocalDateTime.now());

        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
        orderStatusHistory.setOrder(order);
        orderStatusHistory.setStatus(OrderStatus.COMPLETED);
        orderStatusHistory.setDescription("Đơn hàng đã giao thành công");
        if (order.getOrderStatusHistories() == null) {
            order.setOrderStatusHistories(new ArrayList<>());
        }
        order.getOrderStatusHistories().add(orderStatusHistory);

        //if cod
        if (order.getPayment().getPaymentMethod().equals(PaymentMethod.COD)) {
            order.getPayment().setPaymentStatus(PaymentStatus.PAID);
            order.getPayment().setPaymentDate(LocalDateTime.now());
        }
        order.getPayment().setPaymentDate(LocalDateTime.now());
        orderRepository.save(order);
    }
}

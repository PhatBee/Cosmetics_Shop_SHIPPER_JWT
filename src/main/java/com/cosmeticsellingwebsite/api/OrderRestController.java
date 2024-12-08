package com.cosmeticsellingwebsite.api;

import com.cosmeticsellingwebsite.payload.response.ApiResponse;
import com.cosmeticsellingwebsite.payload.response.ShippingOrderResponse;
import com.cosmeticsellingwebsite.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/order")
@RestController
public class OrderRestController {
    @Autowired
    OrderService orderService;


    @GetMapping("/allShipping")
    public ResponseEntity<?> getAllOrder(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        List<ShippingOrderResponse> shippingOrderResponseList = orderService.getShippingOrderListWithPage(pageable);
        return new ResponseEntity<>(new ApiResponse<>(true, "Get all shipping order successfully",shippingOrderResponseList), HttpStatus.OK);
    }
    @PostMapping("/updateShipping")
    public ResponseEntity<?> updateShippingOrder(@RequestParam Long orderId){
        orderService.updateOrderComplete(orderId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Update order successfully", null), HttpStatus.OK);
    }


}

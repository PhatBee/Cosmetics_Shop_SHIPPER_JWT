package com.cosmeticsellingwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
    //get all list shipping order (để shipper cập nhật thành completed)

    @GetMapping("/list-shipping-order")
    public String listShippingOrder(){
        return "list-shipping-order";
    }


}

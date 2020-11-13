package com.whizen.order.service;

import com.whizen.hystrix.HystrixHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class HystrixService implements HystrixHandle<String,String> {
    @RequestMapping("/fallback")
    @Override
    public String handler(String s) {
        log.warn("the order rest for some while");
        return "order for hystrix";
    }
}

package com.whizen.order.service;
import com.whizen.consul.EnvClientPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order/api")
@Slf4j
public class UOrderService {
    @Autowired
    private EnvClientPath path;
    @Value("${server.port}")
    private Integer port;
    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    private RestTemplate loadBalancedRestTemplate;

    @RequestMapping("/done/create-order")
    public String createOrder(){
        log.warn("store api request path：{}",loadBalancedRestTemplate.getForEntity(path.getUStorePath()+"/store/api/done/store",String.class,new Object[0]));
        return "薯片来一片"+":"+port;
    }

    @RequestMapping("/done/create-order-hystrix")
    public String hystrixCreateOrder(){
        log.warn("hello,just test it");
        return "good luck";
    }

}

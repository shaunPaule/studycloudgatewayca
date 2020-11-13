package com.whizen.store.service;

import com.whizen.consul.EnvClientPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/api")
@Slf4j
public class UStoreService {
    @Autowired
    private EnvClientPath path;
    @RequestMapping("/done/store")
    public String storeGoods(){
        return "薯片库存减一";
    }
}

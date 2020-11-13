package com.whizen.hystrix;

public interface HystrixHandle<T,S>{
    S handler(T t);
}

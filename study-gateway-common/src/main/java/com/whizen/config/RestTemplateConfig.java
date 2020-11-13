package com.whizen.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfig {
    private int readTimeout;
    private int connectTimeout;

    @Bean("iowzClientHttpRequestFactory")
    public SimpleClientHttpRequestFactory clientHttpRequestFactory(){
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(this.readTimeout);
        clientHttpRequestFactory.setConnectTimeout(this.connectTimeout);
        return clientHttpRequestFactory;
    }

    @Bean("loadBalancedRestTemplate")
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate(@Qualifier("iowzClientHttpRequestFactory") SimpleClientHttpRequestFactory clientHttpRequestFactory){
        return  this.newRestTemplate(clientHttpRequestFactory);
    }

    @Bean("singletonRestTemplate")
    public RestTemplate singletonRestTemplate(@Qualifier("iowzClientHttpRequestFactory") SimpleClientHttpRequestFactory clientHttpRequestFactory){
        return  this.newRestTemplate(clientHttpRequestFactory);
    }

    private RestTemplate newRestTemplate(SimpleClientHttpRequestFactory clientHttpRequestFactory){
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(1);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

}

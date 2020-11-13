package com.whizen.consul;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("env.client-path")
@Data
public class EnvClientPath {
    private String UStorePath;
    private String UOrderPath;
}

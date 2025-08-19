package com.example.jwtboilerplate.global.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("jwt")
public class JwtProperties {
    private final long accessTime;
    private final long refreshTime;
    private final String prefix;
    private final String header;
    private final String secretKey;
}
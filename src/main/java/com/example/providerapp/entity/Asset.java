package com.example.providerapp.entity;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private String id;
    private String name;
    private String contentType;
    private String baseUrl;
    private String proxyPath;
    private Instant createdAt;
}

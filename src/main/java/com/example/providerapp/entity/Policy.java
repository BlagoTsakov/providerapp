package com.example.providerapp.entity;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policy implements IEntity {
    private String id;
    private String type;
    private Instant createdAt;
}

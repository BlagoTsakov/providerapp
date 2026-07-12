package com.example.providerapp.entity;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDefinition implements IEntity {
    private String id;
    private String accessPolicyId;
    private String contractPolicyId;
    private Instant createdAt;
}

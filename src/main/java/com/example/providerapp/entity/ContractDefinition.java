package com.example.providerapp.entity;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDefinition implements IEntity {
    private String id;
    private String accessPolicyId;
    private String contractPolicyId;
    private List<String> assetsSelector;
    private Instant createdAt;
}

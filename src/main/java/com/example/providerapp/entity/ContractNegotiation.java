package com.example.providerapp.entity;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractNegotiation implements IEntity {
    private String id;
    private NegotiationState state;
    private String counterPartyId;
    private String offerId;
    private String assetId;
    private String agreementId;
    private Instant createdAt;
    private Instant stateTimestamp;

    public void transitionTo(NegotiationState newState) {
        this.state = newState;
        this.stateTimestamp = Instant.now();
    }
}

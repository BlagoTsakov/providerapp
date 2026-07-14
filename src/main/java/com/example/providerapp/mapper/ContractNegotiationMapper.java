package com.example.providerapp.mapper;

import com.example.providerapp.entity.ContractNegotiation;
import com.example.providerapp.entity.NegotiationState;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationRequestDTO;
import com.example.providerapp.model.contractnegotiation.PolicyOfferDTO;

import java.time.Instant;
import java.util.UUID;

public final class ContractNegotiationMapper {
    private ContractNegotiationMapper() {}

    public static ContractNegotiation toContractNegotiation(ContractNegotiationRequestDTO request) {
        Instant now = Instant.now();
        PolicyOfferDTO policy = request.getPolicy();

        return ContractNegotiation.builder()
                .id(UUID.randomUUID().toString())
                .state(NegotiationState.REQUESTED)
                .counterPartyId(request.getCounterPartyId())
                .offerId(policy.getId())
                .assetId(policy.getTarget())
                .createdAt(now)
                .stateTimestamp(now)
                .build();
    }

    public static ContractNegotiationDTO toContractNegotiationDTO(ContractNegotiation negotiation) {
        return ContractNegotiationDTO.builder()
                .id(negotiation.getId())
                .state(negotiation.getState().name())
                .counterPartyId(negotiation.getCounterPartyId())
                .agreementId(negotiation.getAgreementId())
                .createdAt(negotiation.getCreatedAt().toEpochMilli())
                .build();
    }
}

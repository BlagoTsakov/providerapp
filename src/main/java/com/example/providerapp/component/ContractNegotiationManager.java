package com.example.providerapp.component;

import com.example.providerapp.entity.ContractNegotiation;
import com.example.providerapp.entity.NegotiationState;
import com.example.providerapp.repository.contractnegotiation.IContractNegotiationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContractNegotiationManager {
    private final IContractNegotiationRepository contractNegotiationRepository;

    @Scheduled(fixedDelayString = "${negotiation.tick-ms:2000}")
    public void tick() {
        contractNegotiationRepository.findAll().stream()
                .filter(negotiation -> !negotiation.getState().isTerminatedOrFinalized())
                .forEach(this::processNegotiation);
    }

    private void processNegotiation(ContractNegotiation negotiation) {
        NegotiationState from = negotiation.getState();
        NegotiationState next = nextState(from);
        if (next == null) {
            log.info("Unexpected Negotiation: {}", negotiation.getId());
            return;
        }

        if ((next == NegotiationState.AGREED) && (negotiation.getAgreementId() == null)) {
            negotiation.setAgreementId(UUID.randomUUID().toString());
        }

        negotiation.transitionTo(next);
        contractNegotiationRepository.update(negotiation);
        log.info("Negotiation {}: {} -> {}", negotiation.getId(), from, next);
    }

    private NegotiationState nextState(NegotiationState current) {
        return switch (current) {
            case REQUESTED -> NegotiationState.OFFERED;
            case OFFERED -> NegotiationState.ACCEPTED;
            case ACCEPTED -> NegotiationState.AGREED;
            case AGREED -> NegotiationState.VERIFIED;
            case VERIFIED -> NegotiationState.FINALIZED;
            case FINALIZED, TERMINATED -> null;
        };
    }
}

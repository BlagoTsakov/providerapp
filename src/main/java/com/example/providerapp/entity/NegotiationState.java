package com.example.providerapp.entity;

// https://github.com/International-Data-Spaces-Association/ids-specification/blob/main/negotiation/contract.negotiation.protocol.md
public enum NegotiationState {
    REQUESTED,
    OFFERED,
    ACCEPTED,
    AGREED,
    VERIFIED,
    FINALIZED,
    TERMINATED;

    public boolean isTerminatedOrFinalized() {
        return (this == TERMINATED) || (this == FINALIZED);
    }
}

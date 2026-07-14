package com.example.providerapp.service.contractnegotiation;

import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationRequestDTO;

public interface IContractNegotiationService {
    ResponseDTO initiate(ContractNegotiationRequestDTO request);
    ContractNegotiationDTO getById(String id);
}

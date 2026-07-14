package com.example.providerapp.controller;

import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationRequestDTO;
import com.example.providerapp.service.contractnegotiation.IContractNegotiationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.providerapp.util.Constants.MANAGEMENT;
import static com.example.providerapp.util.Constants.REST_VERSION;

@Slf4j
@RestController
@RequiredArgsConstructor
class ContractNegotiationController {
    private static final String CONTRACT_NEGOTIATIONS = "contractnegotiations";
    private static final String CONTRACT_NEGOTIATIONS_PATH = "/" + MANAGEMENT + "/" + REST_VERSION + "/" + CONTRACT_NEGOTIATIONS;

    private final IContractNegotiationService contractNegotiationService;

    @PostMapping(CONTRACT_NEGOTIATIONS_PATH)
    public ResponseEntity<ResponseDTO> handlePost(@Validated @RequestBody ContractNegotiationRequestDTO request) {
        log.info("handlePost: initiate negotiation with {}", request.getCounterPartyId());
        ResponseDTO response = contractNegotiationService.initiate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(CONTRACT_NEGOTIATIONS_PATH + "/{id}")
    public ContractNegotiationDTO handleGet(@PathVariable String id) {
        log.info("handleGet: negotiation {}", id);
        return contractNegotiationService.getById(id);
    }
}

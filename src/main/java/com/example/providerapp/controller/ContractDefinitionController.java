package com.example.providerapp.controller;

import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;
import com.example.providerapp.service.contractdefinition.IContractDefinitionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.providerapp.util.Constants.MANAGEMENT;
import static com.example.providerapp.util.Constants.REST_VERSION;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContractDefinitionController {
    private static final String CONTRACT_DEFINITIONS = "contractdefinitions";
    private static final String CONTRACT_DEFINITIONS_PATH = "/" + MANAGEMENT + "/" + REST_VERSION + "/" + CONTRACT_DEFINITIONS;

    private final IContractDefinitionService contractDefinitionService;

    @PostMapping(CONTRACT_DEFINITIONS_PATH)
    public ResponseEntity<ResponseDTO> handlePost(@Validated @RequestBody ContractDefinitionDTO contractDefinitionDTO) {
        log.info("handlePost: ID: {}", contractDefinitionDTO.getId());
        ResponseDTO response = contractDefinitionService.createContractDefinition(contractDefinitionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

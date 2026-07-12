package com.example.providerapp.controller;

import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.policy.PolicyDTO;
import com.example.providerapp.service.policy.IPolicyService;
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
class PolicyController {
    private static final String POLICY_DEFINITIONS = "policydefinitions";
    private static final String POLICY_DEFINITIONS_PATH = "/" + MANAGEMENT + "/" + REST_VERSION + "/" + POLICY_DEFINITIONS;

    private final IPolicyService policyService;

    @PostMapping(POLICY_DEFINITIONS_PATH)
    public ResponseEntity<IdResponseDTO> handlePost(@Validated @RequestBody PolicyDTO policyDTO) {
        log.info("handlePost: ID: {}", policyDTO.getId());
        IdResponseDTO response = policyService.createPolicy(policyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

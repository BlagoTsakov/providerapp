package com.example.providerapp.controller;

import com.example.providerapp.model.createasset.CreateAssetDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.providerapp.util.Constants.REST_API_VERSION;

@Slf4j
@RestController
class NegotiationController {
    public static final String MANAGEMENT_ASSETS_PATH = "management/" + REST_API_VERSION + "/assets";

    @PostMapping(MANAGEMENT_ASSETS_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody CreateAssetDTO createAssetDTO) {
        log.info("handlePost: ID: {}", createAssetDTO.id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
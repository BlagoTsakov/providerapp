package com.example.providerapp.controller;

import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;
import com.example.providerapp.service.IAssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.providerapp.util.Constants.REST_API_VERSION;

@Slf4j
@RestController
@RequiredArgsConstructor
class AssetController {
    public static final String MANAGEMENT_ASSETS_PATH = "/management/" + REST_API_VERSION + "/assets";

    private final IAssetService assetService;

    @PostMapping(MANAGEMENT_ASSETS_PATH)
    public ResponseEntity<IdResponseDTO> handlePost(@Validated @RequestBody AssetDTO assetDTO) {
        log.info("handlePost: ID: {}", assetDTO.getId());
        IdResponseDTO response = assetService.createAsset(assetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
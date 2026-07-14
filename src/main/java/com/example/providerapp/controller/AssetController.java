package com.example.providerapp.controller;

import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;
import com.example.providerapp.service.asset.IAssetService;
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
class AssetController {
    private static final String ASSETS = "assets";
    private static final String ASSETS_PATH = "/" + MANAGEMENT + "/" + REST_VERSION + "/" + ASSETS;

    private final IAssetService assetService;

    @PostMapping(ASSETS_PATH)
    public ResponseEntity<ResponseDTO> handlePost(@Validated @RequestBody AssetDTO assetDTO) {
        log.info("handlePost: ID: {}", assetDTO.getId());
        ResponseDTO response = assetService.createAsset(assetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
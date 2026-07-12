package com.example.providerapp.controller;

import com.example.providerapp.model.catalog.CatalogEntryDTO;
import com.example.providerapp.model.catalog.CatalogRequestDTO;
import com.example.providerapp.service.catalog.ICatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.providerapp.util.Constants.MANAGEMENT;
import static com.example.providerapp.util.Constants.REST_VERSION;

@Slf4j
@RestController
@RequiredArgsConstructor
class CatalogController {
    private static final String CATALOG_REQUEST = "catalog/request";
    private static final String CATALOG_PATH = "/" + MANAGEMENT + "/" + REST_VERSION + "/" + CATALOG_REQUEST;

    private final ICatalogService catalogService;

    @PostMapping(CATALOG_PATH)
    public List<CatalogEntryDTO> handlePost(@Validated @RequestBody CatalogRequestDTO catalogRequestDTO) {
        log.info("handlePost: catalog request from {}", catalogRequestDTO.getCounterPartyAddress());
        return catalogService.getCatalog();
    }
}

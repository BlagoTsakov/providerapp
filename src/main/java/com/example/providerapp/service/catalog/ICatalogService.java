package com.example.providerapp.service.catalog;

import com.example.providerapp.model.catalog.CatalogEntryDTO;

import java.util.List;

public interface ICatalogService {
    List<CatalogEntryDTO> getCatalog();
}

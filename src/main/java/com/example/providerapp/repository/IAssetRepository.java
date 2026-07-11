package com.example.providerapp.repository;

import com.example.providerapp.entity.Asset;

public interface IAssetRepository {
    SaveResult save(Asset asset);
}

package com.example.providerapp.repository.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.repository.SaveResult;

public interface IAssetRepository {
    SaveResult save(Asset asset);
}

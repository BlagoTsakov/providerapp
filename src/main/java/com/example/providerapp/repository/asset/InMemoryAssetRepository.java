package com.example.providerapp.repository.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.repository.SaveResult;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAssetRepository implements IAssetRepository {
    private final Map<String, Asset> assets = new ConcurrentHashMap<>();

    @Override
    public SaveResult save(Asset asset) {
        String assetId = asset.getId();
        Asset previous = assets.putIfAbsent(assetId, asset);

        if (previous != null) {
            return new SaveResult.AlreadyExists(assetId);
        }

        return new SaveResult.Saved(asset);
    }
}

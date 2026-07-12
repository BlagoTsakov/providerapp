package com.example.providerapp.mapper;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.model.asset.AssetDTO;
import com.example.providerapp.model.asset.DataAddressDTO;
import com.example.providerapp.model.asset.PropertiesDTO;

import java.time.Instant;

public final class AssetMapper {
    private AssetMapper() {}

    public static Asset toAsset(AssetDTO assetDTO) {
        PropertiesDTO properties = assetDTO.getProperties();
        DataAddressDTO dataAddress = assetDTO.getDataAddress();

        return Asset.builder()
                .id(assetDTO.getId())
                .name(properties.getName())
                .contentType(properties.getContenttype())
                .baseUrl(dataAddress.getBaseUrl())
                .proxyPath(dataAddress.getProxyPath())
                .createdAt(Instant.now())
                .build();
    }
}

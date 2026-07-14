package com.example.providerapp.service.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;

import java.util.List;

public interface IAssetService {
    ResponseDTO createAsset(AssetDTO assetDTO);
    List<Asset> findAll();
    boolean exists(String id);
}

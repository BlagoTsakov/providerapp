package com.example.providerapp.service;

import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;

public interface IAssetService {
    IdResponseDTO createAsset(AssetDTO assetDTO);
}

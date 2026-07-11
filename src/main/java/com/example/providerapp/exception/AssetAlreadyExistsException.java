package com.example.providerapp.exception;

public class AssetAlreadyExistsException extends RuntimeException {
    public AssetAlreadyExistsException(String assetId) {
        super("Asset already exists: " + assetId);
    }
}

package com.example.providerapp.repository;

import com.example.providerapp.entity.Asset;

public sealed interface SaveResult {
    record Saved(Asset asset) implements SaveResult {
    }

    record AlreadyExists(String id) implements SaveResult {
    }
}

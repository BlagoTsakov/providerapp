package com.example.providerapp.repository.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.repository.base.BaseInMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryAssetRepository extends BaseInMemoryRepository<Asset> implements IAssetRepository {
}

package com.example.providerapp.repository.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.repository.save.SaveRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryAssetRepository extends SaveRepository<Asset> implements IAssetRepository {
}

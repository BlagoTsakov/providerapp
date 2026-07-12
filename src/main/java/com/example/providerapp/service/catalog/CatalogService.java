package com.example.providerapp.service.catalog;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.model.catalog.CatalogEntryDTO;
import com.example.providerapp.service.asset.IAssetService;
import com.example.providerapp.service.contractdefinition.IContractDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.providerapp.mapper.CatalogMapper.toEntry;

@Service
@RequiredArgsConstructor
public class CatalogService implements ICatalogService {
    private final IAssetService assetService;
    private final IContractDefinitionService contractDefinitionService;

    @Override
    public List<CatalogEntryDTO> getCatalog() {
        List<ContractDefinition> definitions = contractDefinitionService.findAll();

        return assetService.findAll().stream()
                .map(asset -> toEntry(asset.getId(), matchingDefinitions(asset.getId(), definitions)))
                .filter(entry -> !entry.getOffers().isEmpty())
                .toList();
    }

    private List<ContractDefinition> matchingDefinitions(String assetId, List<ContractDefinition> definitions) {
        return definitions.stream()
                .filter(definition -> appliesTo(definition, assetId))
                .toList();
    }

    private boolean appliesTo(ContractDefinition definition, String assetId) {
        List<String> selector = definition.getAssetsSelector();
        return (selector == null) || selector.isEmpty() || selector.contains(assetId);
    }
}

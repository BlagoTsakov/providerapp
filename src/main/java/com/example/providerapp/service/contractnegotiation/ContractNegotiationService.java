package com.example.providerapp.service.contractnegotiation;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.entity.ContractNegotiation;
import com.example.providerapp.exception.EntityNotFoundException;
import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationDTO;
import com.example.providerapp.model.contractnegotiation.ContractNegotiationRequestDTO;
import com.example.providerapp.repository.contractnegotiation.IContractNegotiationRepository;
import com.example.providerapp.service.asset.IAssetService;
import com.example.providerapp.service.contractdefinition.IContractDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.providerapp.mapper.ContractNegotiationMapper.toContractNegotiationDTO;
import static com.example.providerapp.mapper.ContractNegotiationMapper.toContractNegotiation;

@Service
@RequiredArgsConstructor
public class ContractNegotiationService implements IContractNegotiationService {
    private static final String SERVICE_ID = "ContractNegotiation";
    private static final String ASSET = "Asset";
    private static final String OFFER = "ContractDefinition";

    private final IContractNegotiationRepository contractNegotiationRepository;
    private final IAssetService assetService;
    private final IContractDefinitionService contractDefinitionService;
    private final EntityCreator entityCreator;

    @Override
    public ResponseDTO initiate(ContractNegotiationRequestDTO request) {
        requireAssetExists(request.getPolicy().getTarget());
        requireOfferExists(request.getPolicy().getId());

        return entityCreator.create(contractNegotiationRepository, toContractNegotiation(request), SERVICE_ID);
    }

    @Override
    public ContractNegotiationDTO getById(String id) {
        ContractNegotiation negotiation = contractNegotiationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(SERVICE_ID, id));
        return toContractNegotiationDTO(negotiation);
    }

    private void requireAssetExists(String assetId) {
        if (!assetService.exists(assetId)) {
            throw new EntityNotFoundException(ASSET, assetId);
        }
    }

    private void requireOfferExists(String offerId) {
        if (!contractDefinitionService.exists(offerId)) {
            throw new EntityNotFoundException(OFFER, offerId);
        }
    }
}

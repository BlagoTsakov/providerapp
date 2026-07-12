package com.example.providerapp.model.contractdefinition;

import com.example.providerapp.model.ContextDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.example.providerapp.util.Extensions.isNotNullOrBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDefinitionDTO {
    @Valid
    @NotNull
    @JsonProperty("@context")
    private ContextDTO context;

    @JsonProperty("@id")
    private String id;

    @NotBlank
    private String accessPolicyId;

    @NotBlank
    private String contractPolicyId;

    @NotNull
    private List<String> assetsSelector;

    @JsonCreator
    public static ContractDefinitionDTO create(
            @JsonProperty("@context") ContextDTO context,
            @JsonProperty("@id") String id,
            @JsonProperty("accessPolicyId") String accessPolicyId,
            @JsonProperty("contractPolicyId") String contractPolicyId,
            @JsonProperty("assetsSelector") List<String> assetsSelector
    ) {
        return ContractDefinitionDTO.builder()
                .context(context)
                .id(isNotNullOrBlank(id) ? id : UUID.randomUUID().toString())
                .accessPolicyId(accessPolicyId)
                .contractPolicyId(contractPolicyId)
                .assetsSelector(assetsSelector)
                .build();
    }
}

package com.example.providerapp.model.catalog;

import com.example.providerapp.model.common.ContextDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogRequestDTO {
    @Valid
    @NotNull
    @JsonProperty("@context")
    private ContextDTO context;

    @NotBlank
    private String counterPartyId;

    @NotBlank
    private String counterPartyAddress;

    @NotBlank
    private String protocol;
}

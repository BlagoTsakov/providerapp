package com.example.providerapp.model.createasset;

import com.example.providerapp.model.ContextDTO;
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
public class CreateAssetDTO {
    @Valid
    @NotNull
    @JsonProperty("@context")
    public ContextDTO context;

    @NotBlank
    @NotNull
    @JsonProperty("@id")
    public String id;

    @Valid
    @NotNull
    public PropertiesDTO properties;

    @Valid
    @NotNull
    public DataAddressDTO dataAddress;
}

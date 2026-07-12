package com.example.providerapp.model.policy;

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
public class PolicyDTO {
    @Valid
    @NotNull
    @JsonProperty("@context")
    private ContextDTO context;

    @NotBlank
    @JsonProperty("@id")
    private String id;

    @Valid
    @NotNull
    @JsonProperty("policy")
    private PolicySettingsDTO policySettings;
}

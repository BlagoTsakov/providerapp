package com.example.providerapp.model.policy;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicySettingsDTO {
    @NotBlank
    @JsonProperty("@context")
    private String context;

    @NotNull
    private List<String> permission;

    @NotNull
    private List<String> prohibition;

    @NotNull
    private List<String> obligation;

    @NotBlank
    @JsonProperty("@type")
    private String type;
}

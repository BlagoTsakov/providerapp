package com.example.providerapp.model.policy;

import com.example.providerapp.model.ContextDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicySettingsDTO {
    @NotBlank
    @JsonProperty("@context")
    public String context;

    @NotNull
    public ArrayList<String> permission;

    @NotNull
    public ArrayList<String> prohibition;

    @NotNull
    public ArrayList<String> obligation;

    @NotBlank
    @JsonProperty("@type")
    public String type;
}

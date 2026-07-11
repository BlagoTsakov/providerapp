package com.example.providerapp.model.createasset;

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
public class PropertiesDTO {
    @NotBlank
    @NotNull
    public String name;

    @NotBlank
    @NotNull
    public String contenttype;
}

package com.example.providerapp.model.asset;

import jakarta.validation.constraints.NotBlank;
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
    private String name;

    @NotBlank
    private String contenttype;
}

package com.example.providerapp.model.asset;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAddressDTO {
    @NotBlank
    @Pattern(regexp = "HttpData", message = "Invalid type")
    private String type;

    @NotBlank
    private String name;

    @NotBlank
    @URL
    private String baseUrl;

    @NotBlank
    private String proxyPath;
}

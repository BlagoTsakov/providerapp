package com.example.providerapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDTO {
    private String message;
    private String type;
    private String path;
    private Object invalidValue;
}

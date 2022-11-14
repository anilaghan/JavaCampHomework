package com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {
    private int id;
    private String name;
}

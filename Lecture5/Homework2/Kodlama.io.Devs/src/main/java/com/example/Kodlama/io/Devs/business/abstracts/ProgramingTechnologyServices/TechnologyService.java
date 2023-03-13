package com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices;

import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.TechnologyResponse;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingTechnology;

import java.util.List;

public interface TechnologyService {

    List<GetAllTechnologyResponse> getAll();
    TechnologyResponse getById(int id);
    TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest)throws Exception;
    TechnologyResponse toTechnologyResponse(ProgramingTechnology programingTechnology);
    TechnologyResponse update(int id,UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    void delete(int id);
}

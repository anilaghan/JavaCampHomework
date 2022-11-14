package com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices;

import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.DeleteTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;

import java.util.List;

public interface TechnologyService {

    List<GetAllTechnologyResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest)throws Exception;

    void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    void delete(DeleteTechnologyRequest deleteLanguageRequest);
}

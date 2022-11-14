package com.example.Kodlama.io.Devs.webApi.controllers;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices.TechnologyService;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.DeleteTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class ProgramingTechnologyController {
    private TechnologyService technologyService;

    @Autowired
    private ProgramingTechnologyController(TechnologyService technologyService){
        this.technologyService=technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
        technologyService.update(updateTechnologyRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest){
        technologyService.delete(deleteTechnologyRequest);
    }
}

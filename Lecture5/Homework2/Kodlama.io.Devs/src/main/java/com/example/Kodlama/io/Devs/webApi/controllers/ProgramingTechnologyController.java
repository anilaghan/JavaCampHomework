package com.example.Kodlama.io.Devs.webApi.controllers;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices.TechnologyService;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.TechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/technologies")
public class ProgramingTechnologyController {
    private TechnologyService technologyService;

    @Autowired
    private ProgramingTechnologyController(TechnologyService technologyService){
        this.technologyService=technologyService;
    }
    @GetMapping
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
        public ResponseEntity<TechnologyResponse> getById (@PathVariable int id){
            TechnologyResponse technologyResponse = technologyService.getById(id);
            if(Objects.nonNull(technologyResponse)){
                return new ResponseEntity<>(technologyResponse, HttpStatus.OK);
            }
            return null;
        }
    @PostMapping
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }
    @PutMapping("/{id}")
    public ResponseEntity <TechnologyResponse> update(@PathVariable int id,@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
       TechnologyResponse technologyResponse = technologyService.update(id,updateTechnologyRequest);
       if(Objects.nonNull(technologyResponse)){
           return new ResponseEntity<>(technologyResponse,HttpStatus.OK);
       }
       return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        technologyService.delete(id);
    }
}

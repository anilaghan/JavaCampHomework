package com.example.Kodlama.io.Devs.webApi.controllers;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class ProgramingLanguagesController {

	private LanguageService languageService;

	@Autowired
	public ProgramingLanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LanguageResponse> getById (@PathVariable int id){
		LanguageResponse languageResponse = languageService.getLanguageResponseById(id);
		if(Objects.nonNull(languageResponse)){
			return new ResponseEntity<>(languageResponse, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping
	public void create(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LanguageResponse> update (@PathVariable int id,@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		LanguageResponse languageResponse = languageService.update(id, updateLanguageRequest);
		if(Objects.nonNull(languageResponse)){
			return new ResponseEntity<>(languageResponse,HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();

	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		languageService.delete(id);
	}

}

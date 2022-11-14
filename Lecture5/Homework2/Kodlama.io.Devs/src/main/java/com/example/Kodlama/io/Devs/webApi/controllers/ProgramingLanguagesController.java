package com.example.Kodlama.io.Devs.webApi.controllers;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.DeleteLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class ProgramingLanguagesController {

	private LanguageService languageService;

	@Autowired
	public ProgramingLanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void create(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest){
		languageService.delete(deleteLanguageRequest);
	}


/*



	@DeleteMapping("/{id}")
	public void delete(int id) throws Exception {
		languageService.delete(id);
	}*/
}

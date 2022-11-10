package com.example.Kodlama.io.Devs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.Kodlama.io.Devs.business.abstracts.LanguageService;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgramingLanguagesController {

	private LanguageService languageService;

	@Autowired
	public ProgramingLanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<ProgramingLanguage> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public ProgramingLanguage getById(@PathVariable() int id) throws Exception {
		return languageService.getById(id);
	}

	@PostMapping("/add")
	public void create(@RequestBody ProgramingLanguage language) throws Exception {
		languageService.add(language);
	}

	@PutMapping("/update")
	public void update(@RequestBody ProgramingLanguage language, int id, String name) throws Exception {
		languageService.update(language, id, name);
	}

	@DeleteMapping("/{id}")
	public void delete(int id) throws Exception {
		languageService.delete(id);
	}
}

package com.example.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

public interface LanguageService {

	List<ProgramingLanguage> getAll();

	public void add(ProgramingLanguage language)throws Exception;

	public void update(ProgramingLanguage language, int id, String name)throws Exception;

	public void delete(int id) throws Exception;

	public ProgramingLanguage getById(int id) throws Exception;
}

package com.example.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

public interface LanguageRepository {
	
	List<ProgramingLanguage> getAll();

	public void add(ProgramingLanguage language);

	public void update(ProgramingLanguage language,int id,String name);

	public void delete(int id);
	
	public ProgramingLanguage getById(int id)throws Exception;
}

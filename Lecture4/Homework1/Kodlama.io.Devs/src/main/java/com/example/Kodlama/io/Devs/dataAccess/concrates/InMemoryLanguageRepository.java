package com.example.Kodlama.io.Devs.dataAccess.concrates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<ProgramingLanguage> programinglanguages;

	public InMemoryLanguageRepository() {
		programinglanguages = new ArrayList<ProgramingLanguage>();
		programinglanguages.add(new ProgramingLanguage(1, "Java"));
		programinglanguages.add(new ProgramingLanguage(2, "C#"));
		programinglanguages.add(new ProgramingLanguage(3, "Python"));

	}

	@Override
	public List<ProgramingLanguage> getAll() {

		return programinglanguages;
	}

	@Override
	public void add(ProgramingLanguage language) {
		programinglanguages.add(language);

	}

	@Override
	public void update(ProgramingLanguage language, int id, String name) {
		language.setId(id);
		language.setName(name);
	}

	@Override
	public void delete(int id){
		programinglanguages.remove(id);
	}

	@Override
	public ProgramingLanguage getById(int id) throws Exception {
		for(ProgramingLanguage language:programinglanguages) {
			if(language.getId() != id) {
				throw new Exception("Böyle bir kayıt bulunamadı");
			}
			
		}
		return null;
		
	}

}

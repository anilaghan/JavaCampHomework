package com.example.Kodlama.io.Devs.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodlama.io.Devs.business.abstracts.LanguageService;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgramingLanguage> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public void add(ProgramingLanguage language) throws Exception {
		if (language.getName().isEmpty()) {
			throw new Exception("Programlama Dili Boş Bırakılamaz");
		}
		for (ProgramingLanguage language1 : getAll()) {
			if (language1.getName() == language.getName()) {
				throw new Exception("Aynı İsimde Programlama Dili Mevcut.");
			}

		}
		languageRepository.add(language);
	}

	@Override
	public void update(ProgramingLanguage language, int id, String name) throws Exception {
		for (ProgramingLanguage language2 : getAll()) {
			if (language2.getId() == id || name.isEmpty()) {
				throw new Exception("Hatalı Giriş Yaptınız, Bilgilerinizi Kontrol Ediniz.");
			}
			languageRepository.update(language, id, name);
		}
	}

	@Override
	public void delete(int id) throws Exception {
		for (ProgramingLanguage language : getAll()) {
			if (language.getId() != id) {
				throw new Exception("Böyle bir kayıt bulunamadı");
			}
		}
		languageRepository.delete(id);

	}

	@Override
	public ProgramingLanguage getById(int id) throws Exception {	
		return languageRepository.getById(id);
	}

}

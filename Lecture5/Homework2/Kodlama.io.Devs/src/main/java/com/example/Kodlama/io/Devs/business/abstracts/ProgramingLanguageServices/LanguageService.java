package com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices;

import java.util.List;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.LanguageResponse;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
	LanguageResponse getLanguageResponseById(int id);

	ProgramingLanguage getLanguageById(int id);

	LanguageResponse add(CreateLanguageRequest createLanguageRequest) throws Exception;

	LanguageResponse toLanguageResponse(ProgramingLanguage programingLanguage);
	LanguageResponse update(int id ,UpdateLanguageRequest updateLanguageRequest) ;

	void delete(int id);

}

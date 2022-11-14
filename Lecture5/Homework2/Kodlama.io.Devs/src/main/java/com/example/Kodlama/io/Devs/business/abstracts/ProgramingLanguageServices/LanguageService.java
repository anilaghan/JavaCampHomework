package com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices;

import java.util.List;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.DeleteLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;

	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

	void delete(DeleteLanguageRequest deleteLanguageRequest);

}

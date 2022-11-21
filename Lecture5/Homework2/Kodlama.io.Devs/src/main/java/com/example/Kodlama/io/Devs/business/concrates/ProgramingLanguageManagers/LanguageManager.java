package com.example.Kodlama.io.Devs.business.concrates.ProgramingLanguageManagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices.LanguageService;
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
    public List<GetAllLanguagesResponse> getAll() {

        List<ProgramingLanguage> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();

        for (ProgramingLanguage language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languagesResponse.add(responseItem);

        }
        return languagesResponse;
    }

    @Override
    public LanguageResponse getLanguageResponseById(int id){
        Optional<ProgramingLanguage> programingLanguage = languageRepository.findById(id);
        return programingLanguage.map(this::toLanguageResponse).orElse(null);
    }

    @Override
    public ProgramingLanguage getLanguageById(int id) {
        return languageRepository.getReferenceById(id);
    }

    @Override
    public LanguageResponse add(CreateLanguageRequest createLanguageRequest) throws Exception {
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(createLanguageRequest.getName());
        if (programingLanguage.getName().isEmpty()) {
            throw new Exception("Programlama Dili Boş Brakılamaz");
        }
        for (GetAllLanguagesResponse languageResponse : getAll()) {
            if (languageResponse.getName().equals(programingLanguage.getName())) {
                throw new Exception("Aynı İsimde Programlama Dili Mevcut.");
            }
        }
        languageRepository.save(programingLanguage);
        return null;
    }

    public LanguageResponse toLanguageResponse(ProgramingLanguage programingLanguage){
        LanguageResponse languageResponse = new LanguageResponse();
        languageResponse.setId(programingLanguage.getId());
        languageResponse.setName(programingLanguage.getName());
        return  languageResponse;
    }
    @Override
    public LanguageResponse update(int id,UpdateLanguageRequest updateLanguageRequest) {
        Optional <ProgramingLanguage> programinLanguage = languageRepository.findById(id);
        if(programinLanguage.isPresent()){
            ProgramingLanguage programingLanguage1= programinLanguage.get();
            programingLanguage1.setName(updateLanguageRequest.getName());
            return toLanguageResponse(languageRepository.save(programingLanguage1));
        }
        return null;
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }
}

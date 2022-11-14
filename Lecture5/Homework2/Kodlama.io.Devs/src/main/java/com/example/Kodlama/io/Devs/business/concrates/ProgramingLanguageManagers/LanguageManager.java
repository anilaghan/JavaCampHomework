package com.example.Kodlama.io.Devs.business.concrates.ProgramingLanguageManagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.CreateLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.DeleteLanguageRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingLanguageRequest.UpdateLanguageRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingLanguageResponse.GetAllLanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices.LanguageService;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
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
    }

    @Override
    @Transactional
    public void update(UpdateLanguageRequest updateLanguageRequest)  throws Exception {
        if(updateLanguageRequest.getName().isBlank()){
            throw new Exception("Dil ismi boş bırakılamaz.");
        }
        ProgramingLanguage programingLanguage = languageRepository.findById(updateLanguageRequest.getId())
                .orElseThrow(()->new EntityNotFoundException("Güncellenecek Dil Bulunamadı"));
        programingLanguage.setName(updateLanguageRequest.getName());
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) {
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setId(deleteLanguageRequest.getId());
        for(GetAllLanguagesResponse languagesResponse : getAll()){
            if(languagesResponse.getId()==programingLanguage.getId()){
                languageRepository.delete(programingLanguage);
            }
        }
    }
}

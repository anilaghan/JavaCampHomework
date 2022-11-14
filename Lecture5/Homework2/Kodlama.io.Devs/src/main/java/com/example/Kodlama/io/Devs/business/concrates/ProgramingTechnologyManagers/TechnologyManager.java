package com.example.Kodlama.io.Devs.business.concrates.ProgramingTechnologyManagers;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices.TechnologyService;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.DeleteTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TechnologyManager implements TechnologyService {

    private LanguageRepository languageRepository;
    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository){
        this.languageRepository=languageRepository;
        this.technologyRepository=technologyRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<ProgramingTechnology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> technologyResponses = new ArrayList<>();

        for(ProgramingTechnology technology:technologies){
            GetAllTechnologyResponse response = new GetAllTechnologyResponse();
            response.setId(technology.getId());
            response.setName(technology.getName());
            response.setPrograminLanguageName(technology.getProgramingLanguage().getName());
            technologyResponses.add(response);
        }
        return technologyResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
        ProgramingLanguage programingLanguage = languageRepository.findById(createTechnologyRequest.getProgramingLanguageId()).get();
        ProgramingTechnology programingTechnology=new ProgramingTechnology();
        programingTechnology.setName(createTechnologyRequest.getName());
        programingTechnology.setProgramingLanguage(programingLanguage);
        if(programingTechnology.getName().isBlank()){
            throw new Exception("Teknoloji İsmi Boş Bırakılamaz.");
        }
        for(GetAllTechnologyResponse technologyResponse:getAll()){
            if(technologyResponse.getName().equals(programingTechnology.getName())){
                throw new Exception("Aynı İsimde Kayıt Var");
            }
        }
        technologyRepository.save(programingTechnology);
    }

    @Override
    @Transactional
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        if(updateTechnologyRequest.getName().isBlank()){
            throw new Exception("Teknoloji ismi boş bırakılamaz.");
        }
        ProgramingTechnology programingTechnology = technologyRepository.findById(updateTechnologyRequest.getId())
                .orElseThrow(()->new EntityNotFoundException("Güncellenecek Programlama Teknolojisi Bulunamadı"));
        programingTechnology.setName(updateTechnologyRequest.getName());
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteLanguageRequest) {
        ProgramingTechnology programingTechnology = new ProgramingTechnology();
        programingTechnology.setId(deleteLanguageRequest.getId());
        for(GetAllTechnologyResponse technologyResponse:getAll()){
            if(technologyResponse.getId()==programingTechnology.getId()){
                technologyRepository.delete(programingTechnology);
            }
        }
    }
}

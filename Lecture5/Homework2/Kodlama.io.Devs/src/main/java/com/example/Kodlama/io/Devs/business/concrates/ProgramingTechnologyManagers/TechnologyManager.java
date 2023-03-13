package com.example.Kodlama.io.Devs.business.concrates.ProgramingTechnologyManagers;

import com.example.Kodlama.io.Devs.business.abstracts.ProgramingLanguageServices.LanguageService;
import com.example.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyServices.TechnologyService;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.CreateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.requests.ProgramingTechnologyRequest.UpdateTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.GetAllTechnologyResponse;
import com.example.Kodlama.io.Devs.business.responses.ProgramingTechnologyResponse.TechnologyResponse;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;
import com.example.Kodlama.io.Devs.entities.concrates.ProgramingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TechnologyManager implements TechnologyService {
    private LanguageService languageService;
    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService){
        this.languageService=languageService;
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
    public TechnologyResponse getById(int id){
        Optional<ProgramingTechnology> programingTechnology= technologyRepository.findById(id);
        return programingTechnology.map((this::toTechnologyResponse)).orElse(null);
    }

    @Override
    public TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
        ProgramingLanguage programingLanguage = languageService.getLanguageById(createTechnologyRequest.getProgramingLanguageId());
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
        return null;
    }

    @Override
    public TechnologyResponse update(int id,UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        Optional<ProgramingTechnology>programingTechnology=technologyRepository.findById(id);
        if(programingTechnology.isPresent()){
            ProgramingTechnology programingTechnology1 = programingTechnology.get();
            programingTechnology1.setName(updateTechnologyRequest.getName());
            return toTechnologyResponse(technologyRepository.save(programingTechnology1));
        }
        return null;
    }

    public TechnologyResponse toTechnologyResponse (ProgramingTechnology programingTechnology){
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setId(programingTechnology.getId());
        technologyResponse.setName(programingTechnology.getName());
        technologyResponse.setLanguageName(programingTechnology.getProgramingLanguage().getName());
        return technologyResponse;
    }
    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}

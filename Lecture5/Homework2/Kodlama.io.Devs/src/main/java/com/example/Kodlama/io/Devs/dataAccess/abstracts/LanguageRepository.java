package com.example.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import com.example.Kodlama.io.Devs.entities.concrates.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {

}

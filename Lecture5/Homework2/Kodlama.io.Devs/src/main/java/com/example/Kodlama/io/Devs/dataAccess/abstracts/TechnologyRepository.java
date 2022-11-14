package com.example.Kodlama.io.Devs.dataAccess.abstracts;

import com.example.Kodlama.io.Devs.entities.concrates.ProgramingTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<ProgramingTechnology, Integer> {
}

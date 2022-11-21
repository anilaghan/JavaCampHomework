package com.example.Kodlama.io.Devs.entities.concrates;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="programingLanguage")
public class ProgramingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "programingLanguage")
	private List<ProgramingTechnology> programingTechnologies ;

}

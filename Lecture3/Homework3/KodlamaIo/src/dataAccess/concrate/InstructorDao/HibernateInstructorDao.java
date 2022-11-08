package dataAccess.concrate.InstructorDao;

import dataAccess.abstracts.InstructorDao;
import entities.Instructor;

public class HibernateInstructorDao implements InstructorDao {

	@Override
	public void add(Instructor instructor) {
		System.out.println("Eğitmen Hibernate ile Eklenmiştir. " + instructor.getFirstName() + " " + instructor.getLastName());

	}

	@Override
	public void update(Instructor instructor) {
		System.out.println("Eğitmen Hibernate ile Güncellenmiştir. " + instructor.getFirstName() + " " + instructor.getLastName());

	}

	@Override
	public void delete(Instructor instructor) {
		System.out.println("Eğitmen Hibernate ile Silinmiştir.  " + instructor.getFirstName() + " " + instructor.getLastName());

	}

}

package dataAccess.concrate.InstructorDao;

import dataAccess.abstracts.InstructorDao;
import entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{

	@Override
	public void add(Instructor instructor) {
		System.out.println("Eğitmen Jdbc ile veritabanına eklenmiştir. " + instructor.getFirstName() + " "+ instructor.getLastName());
		
	}

	@Override
	public void update(Instructor instructor) {
		System.out.println("Eğitmen Jdbc ile veritabanına güncellenmiştir. "+ instructor.getFirstName() + " "+ instructor.getLastName());
		
	}

	@Override
	public void delete(Instructor instructor) {
		System.out.println("Eğitmen Jdbc ile veritabanına silinmiştir. "+ instructor.getFirstName() + " "+ instructor.getLastName());
		
	}

}

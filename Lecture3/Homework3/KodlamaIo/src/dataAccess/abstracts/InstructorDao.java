package dataAccess.abstracts;

import entities.Instructor;

public interface InstructorDao {
	
	public void add(Instructor instructor);

	public void update(Instructor instructor);

	public void delete(Instructor instructor);

}
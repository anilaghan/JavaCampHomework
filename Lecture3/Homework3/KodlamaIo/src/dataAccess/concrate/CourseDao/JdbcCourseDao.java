package dataAccess.concrate.CourseDao;

import dataAccess.abstracts.CourseDao;
import entities.Course;

public class JdbcCourseDao implements CourseDao{

	@Override
	public void add(Course course) {
		System.out.println("Kurs Jdbc İle Eklenmiştir. " + course.getName());
		
	}

	@Override
	public void delete(Course course) {
		System.out.println("Kurs Jdbc İle Silinmiştir. " + course.getName());
	}

	@Override
	public void update(Course course) {
		System.out.println("Kurs Jdbc İle Güncellenmiştir. " + course.getName());
		
	}

}

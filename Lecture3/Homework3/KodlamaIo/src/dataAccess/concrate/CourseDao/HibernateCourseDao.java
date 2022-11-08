package dataAccess.concrate.CourseDao;

import dataAccess.abstracts.CourseDao;
import entities.Course;

public class HibernateCourseDao implements CourseDao{

	@Override
	public void add(Course course) {
		System.out.println("Kurs Hibernate İle Eklenmiştir. " + course.getName());
		
	}

	@Override
	public void delete(Course course) {
		System.out.println("Kurs Hibernate İle Silinmiştir. " + course.getName());
		
	}

	@Override
	public void update(Course course) {
		System.out.println("Kurs Hibernate İle Güncellenmiştir. " + course.getName());
		
	}

}

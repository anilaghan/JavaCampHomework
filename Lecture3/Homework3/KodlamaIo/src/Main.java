import java.util.ArrayList;
import java.util.List;

import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.DatabaseLogger;
import core.FileLogger;
import core.Logger;
import dataAccess.concrate.CategoryDao.JdbcCategoryDao;
import dataAccess.concrate.CourseDao.HibernateCourseDao;
import dataAccess.concrate.InstructorDao.HibernateInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception  {
		
		Logger[] loggers = {new FileLogger(),new DatabaseLogger()};
		
		Instructor instructor = new Instructor();
		instructor.setFirstName("Anıl");
		instructor.setLastName("Ağhan");
		instructor.setId(1);
		
		
		InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(),loggers);

		instructorManager.add(instructor);
		System.out.println("<------------------->");
		instructorManager.delete(instructor);
		System.out.println("<------------------->");
		instructorManager.update(instructor);
		System.out.println("<------------------->");
			
		List<Category> categories = new ArrayList<>();
		
		Category category = new Category();
		category.setId(1);
		category.setName("Eğitimler");
		
		Category category1 = new Category();
		category1.setId(2);
		category1.setName("Eğitimler");
		
		categories.add(category);
		categories.add(category1);
		
		
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(),categories,loggers);
		categoryManager.add(category);
		categoryManager.add(category1);
		
		Course course = new Course();
		
		course.setId(1);
		course.setName("Java");
		course.setCourseInstructor(instructor);
		course.setCategory(category1);
		course.setCourseImageLink("https://www.kodlama.io/image.jpg");
		course.setCourseStatus("%50");
		course.setPrice(0);	
		
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(),loggers);
		
		courseManager.add(course);
		System.out.println("<------------------->");
		courseManager.delete(course);
		System.out.println("<------------------->");
		courseManager.update(course);
		
		
		

	}

}

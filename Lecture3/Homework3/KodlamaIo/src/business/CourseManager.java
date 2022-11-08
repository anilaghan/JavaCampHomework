package business;

import core.Logger;
import dataAccess.abstracts.CourseDao;
import entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;

	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	public void add(Course course) throws Exception {
		if (course.getPrice() < 0) {
			throw new Exception("Kurs Fiyatı 0'dan küçük olamaz");
		} else {
			courseDao.add(course);
			for (Logger logger : loggers) {
				logger.log();
			}
		}
	}

	public void delete(Course course) {
		courseDao.delete(course);
		for (Logger logger : loggers) {
			logger.log();
		}
	}

	public void update(Course course) {
		courseDao.update(course);
		for (Logger logger : loggers) {
			logger.log();
		}
	}

}

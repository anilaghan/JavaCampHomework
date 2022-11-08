package business;

import java.util.List;

import core.Logger;
import dataAccess.abstracts.CategoryDao;
import entities.Category;

public class CategoryManager {
	private CategoryDao categoryDao;
	private List<Category> categories;
	private Logger[] loggers;

	public CategoryManager(CategoryDao categoryDao, List<Category> categories,Logger[] loggers) {
		this.categoryDao = categoryDao;
		this.categories = categories;
		this.loggers=loggers;
	}

	public void add(Category category) throws Exception {
		for (Category category1 : categories) {
			if (category1.getName() == category1.getName()) {
				throw new Exception("Bu isimle bir kategori bulunmaktadır. Lütfen farklı bir isim giriniz.");
			} else {
				categoryDao.add(category);
			}
		}
		for(Logger logger:loggers) {
			logger.log();
		}
	}

	public void delete(Category category) {
		categoryDao.update(category);
		for(Logger logger:loggers) {
			logger.log();
		}
	}

	public void update(Category category) {
		categoryDao.delete(category);
		for(Logger logger:loggers) {
			logger.log();
		}
	}

}

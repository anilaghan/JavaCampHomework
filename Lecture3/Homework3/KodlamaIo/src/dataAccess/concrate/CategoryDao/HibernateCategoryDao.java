package dataAccess.concrate.CategoryDao;

import dataAccess.abstracts.CategoryDao;
import entities.Category;

public class HibernateCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		System.out.println("Kategori Hibernate ile Eklenmiştir. " + category.getName());
		
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kategori Hibernate ile Silinmiştir. " + category.getName());
		
	}

	@Override
	public void update(Category category) {
		System.out.println("Kategori Hibernate ile Güncellenmiştir. " + category.getName());
		
	}

}

package dataAccess.concrate.CategoryDao;

import dataAccess.abstracts.CategoryDao;
import entities.Category;

public class JdbcCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		System.out.println("Kategori Jdbc ile Eklenmiştir. " + category.getName());
		
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kategori Jdbc ile Silinmiştir. " + category.getName());
		
	}

	@Override
	public void update(Category category) {
		System.out.println("Kategori Jdbc ile Güncellenmiştir. " + category.getName());
		
	}

}

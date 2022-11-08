package dataAccess.abstracts;

import entities.Category;

public interface CategoryDao {

	public void add(Category category);

	public void delete(Category category);

	public void update(Category category);
}

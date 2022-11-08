package entities;

public class Course {
	private int id;
	private String name;
	private Instructor courseInstructor;
	private String courseStatus;
	private String courseImageLink;
	private Category category;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instructor getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(Instructor courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseImageLink() {
		return courseImageLink;
	}

	public void setCourseImageLink(String courseImageLink) {
		this.courseImageLink = courseImageLink;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

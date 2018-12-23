package entity;

public class Course implements IEntity {
	private String courseNo;
	private String courseName;
	private int courseGrade;
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}
}

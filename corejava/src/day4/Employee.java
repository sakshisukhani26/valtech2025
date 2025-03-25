package day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Employee implements Comparable<Employee>{

	private long id;
	private String name;
	private int age;
	private float salary;
	private Gender gender;
	private int level;
	private int experience;
//	public static List<Employee> employee = new ArrayList<Employee>();
	
	
	public enum Gender{
		MALE,FEMALE,OTHER;
	}
	
	public Employee(int id,String name,int age,float salary,Gender gender,int level,int experience) {
		super();
		this.id= id;
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.gender=gender;
		this.level=level;
		this.experience=experience;		
	}
	
	public Employee() {}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append(id)
				.append(" ")
				.append(name)
				.append(" ")
				.append(age)
				.append(" ")
				.append(salary)
				.append(" ")
				.append(gender)
				.append(" ")
				.append(level)
				.append(" ")
				.append(experience).toString();
	}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public static class EmployeeBuilder{
		private Employee emp;
		public EmployeeBuilder(Employee emp) {
			this.emp=emp;
		}
		public Employee build() {
//			employee.add(emp);
			return emp;
		}
		public EmployeeBuilder id(int id) {
			emp.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			emp.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			emp.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float sal) {
			emp.setSalary(sal);
			return this;
		}
		public EmployeeBuilder gender(Gender gender) {
			emp.setGender(gender);
			return this;
		}
		public EmployeeBuilder level(int level) {
			emp.setLevel(level);
			return this;
		}
		public EmployeeBuilder experience(int experience) {
			emp.setExperience(experience);
			return this;
		}
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		int levelComparison= Integer.compare(this.level, o.level);
		if(levelComparison!=0) return levelComparison;
		
		int ExperienceComparison= Integer.compare(this.experience, o.experience);
		if(ExperienceComparison!=0) return ExperienceComparison;
		
		int GenderComparison= this.gender.compareTo(o.gender);
		if(GenderComparison!=0) return GenderComparison;
	
		return Float.compare(this.salary, o.salary);
	}
	
//	public static Comparator<Employee> compareByLevel=(e1,e2)->Integer.compare(e1.getLevel(),e2.getLevel());
//	
//	public static Comparator<Employee> compareByExperience=(e1,e2)->Integer.compare(e1.getExperience(),e2.getExperience());
//	
//	public static Comparator<Employee> compareByGender=(e1,e2)->e1.getGender().compareTo(e2.getGender());
//	
//	public static Comparator<Employee> compareBySalary=(e1,e2)->Float.compare(e1.getSalary(),e2.getSalary());
//	
	

}

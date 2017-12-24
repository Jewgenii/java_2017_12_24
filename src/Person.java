
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private char sex;
	
	public Person(String name,int age,char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	@Override
	public int compareTo(Person o) {
		 
		return this.age - o.getAge();
	}
	
	
}

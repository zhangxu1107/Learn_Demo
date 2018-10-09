package cn.zx.test;

public class Test3 {

	/**
	 * ͨ������дһ��ͨ�õ�����ĳ�������ĳ������Ϊָ����ֵ 
	 * * A:������ʾ public void setProperty(Object obj,
	 * String propertyName, Object value){}��
	 * *�˷����ɽ�obj��������ΪpropertyName�����Ե�ֵ����Ϊvalue��
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Student s = new Student("����", 23);
		System.out.println(s);
		
		Tool t = new Tool();
		t.setProperty(s, "name", "����");
		System.out.println(s);
	}

}

class Student {
	private String name;
	private int age;

	public Student() {
		super();

	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
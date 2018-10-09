package cn.zx.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import cn.zx.bean.BaseStudent;
import cn.zx.bean.Student;

public class Demo2_Genric {

	/**
	 * ���͹̶��±߽�
	 * ? super E  
	 * 
	 * ���͹̶��ϱ߽�
	 * ? extends E
	 */
	public static void main(String[] args) {
		deno1();
		TreeSet<Student> ts1 = new TreeSet<>(new CompareByAge());
		ts1.add(new Student("����", 33));
		ts1.add(new Student("����", 13));
		ts1.add(new Student("����", 23));
		ts1.add(new Student("����", 43));
		System.out.println(ts1);
		
		TreeSet<BaseStudent> ts2 = new TreeSet<>(new CompareByAge());
		ts2.add(new BaseStudent("����", 33));
		ts2.add(new BaseStudent("����", 13));
		ts2.add(new BaseStudent("����", 23));
		ts2.add(new BaseStudent("����", 43));
		
		System.out.println(ts2);
	}

	private static void deno1() {
		ArrayList<Student> list1 = new ArrayList<>();
		list1.add(new Student("����", 23));
		list1.add(new Student("����", 24));
		
		ArrayList<BaseStudent> list2 = new ArrayList<>();
		list2.add(new BaseStudent("����", 25));
		list2.add(new BaseStudent("����", 26));
		
		list1.addAll(list2);
		System.out.println(list2);
	}

}



class CompareByAge implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		int num = s1.getAge() - s2.getAge();
		return num == 0 ? s1.getName().compareTo(s2.getName()) :  num;
	}
	
}
package cn.zx.map;

import java.util.Comparator;
import java.util.TreeMap;

import cn.zx.bean.Student;

@SuppressWarnings("unused")
public class Demo7_TreeMap {

	/**
	 * * A:������ʾ
	 * TreeMap���ϼ���Studentֵ��String�İ���
	 */
	public static void main(String[] args) {
		//demo1();
		TreeMap<Student,String> tm = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) { 
				int num = o1.getName().compareTo(o2.getName());  //���������Ƚ�
				return num == 0 ? o1.getAge() - o2.getAge() : num;
			}
			
		});
		tm.put(new Student("����", 23), "����");
		tm.put(new Student("����", 13), "�Ϻ�");
		tm.put(new Student("����", 43), "����");
		tm.put(new Student("����", 33), "����");
		
		System.out.println(tm);
	}

	private static void demo1() {
		TreeMap<Student,String> tm = new TreeMap<>();
		tm.put(new Student("����", 23), "����");
		tm.put(new Student("����", 13), "�Ϻ�");
		tm.put(new Student("����", 33), "����");
		tm.put(new Student("����", 43), "����");
		
		System.out.println(tm);
	}

}

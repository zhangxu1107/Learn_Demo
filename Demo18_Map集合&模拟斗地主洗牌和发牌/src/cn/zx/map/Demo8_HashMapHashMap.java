package cn.zx.map;

import java.util.HashMap;

import cn.zx.bean.Student;

public class Demo8_HashMapHashMap {

	/**
	 * * A:������ʾ
	 * ����Ƕ��֮HashMapǶ��HashMap
	 * 
	 * ����:
	 * ˫Ԫ�����кܶ������
	 * ��88�ڻ����ඨ���һ��˫�м���,����ѧ������,ֵ��ѧ���Ĺ�����
	 * ��99�ڻ����ඨ���һ��˫�м���,����ѧ������,ֵ��ѧ���Ĺ�����
	 * 
	 * ����88�ڻ���99�ڶ��ǰ༶����,����Ϊ�˱���ͳһ����,����Щ�༶������ӵ�˫Ԫ���ü�����
	 */
	public static void main(String[] args) {
		//����88�ڻ�����
		HashMap<Student, String> hm88 = new HashMap<>();
		hm88.put(new Student("����",23) ,"����");
		hm88.put(new Student("����",24) ,"�Ϻ�");
		hm88.put(new Student("����",25) ,"����");
		hm88.put(new Student("����",26) ,"����");
		
		//����99�ڻ�����
		HashMap<Student, String> hm99 = new HashMap<>();
		hm99.put(new Student("��ɮ", 1023), "����");
		hm99.put(new Student("�����",1024), "����");
		hm99.put(new Student("��˽�",1025), "�Ϻ�");
		hm99.put(new Student("ɳ����",1026), "����");
		
		//����˫Ԫ����
		HashMap<HashMap<Student, String>,String> hm = new HashMap<>();
		hm.put(hm88, "��88�ڻ�����");
		hm.put(hm99, "��99�ڻ�����");
		
		//����˫�м���
		for (HashMap<Student, String> h : hm.keySet()) {  //hm.keySet()�������˫�м����м��ļ���
			String value = hm.get(h);       //get(h)���ݼ������ȡֵ����
			//��������˫�м��϶���
			for(Student key : h.keySet()) {		 //h.keySet()��ȡ���������е�ѧ��������
                String value2 = h.get(key);
				System.out.println(key + "=" + value2 + "=" + value);
			}
		}
	}

}

package cn.zx.collections;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unused")
public class Demo1_Collecitons {

	/**
	 * 	Collecitons�еĳ�������
	 * 	public static <T> void sort(List<T> list)
		public static <T> int binarySearch(List<?> list,T key)
		public static <T> T max(Collection<?> coll)
		public static void reverse(List<?> list)
		public static void shuffle(List<?> list)
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("g");
		list.add("f");
		System.out.println("ԭ����" + list);
		System.out.println("�����е����ֵ:" + Collections.max(list)); 			//����Ĭ����������ȡ�����е����ֵ
		Collections.reverse(list);							//��ת����
		System.out.println("��ת����" + list);
		Collections.shuffle(list);							//����û�,��������ϴ��
		System.out.println("����û�" + list);
	}

	private static void demo2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");
		
		System.out.println(Collections.binarySearch(list, "c")); 
		System.out.println(Collections.binarySearch(list, "b"));
	}

	private static void demo1() {
		ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("d");
        
        System.out.println(list);
        Collections.sort(list);   //����������
        System.out.println(list);
	}

}

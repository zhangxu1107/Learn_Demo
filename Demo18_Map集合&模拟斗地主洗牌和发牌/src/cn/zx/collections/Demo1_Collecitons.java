package cn.zx.collections;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unused")
public class Demo1_Collecitons {

	/**
	 * 	Collecitons中的常见方法
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
		System.out.println("原集合" + list);
		System.out.println("集合中的最大值:" + Collections.max(list)); 			//根据默认排序结果获取集合中的最大值
		Collections.reverse(list);							//反转集合
		System.out.println("反转集合" + list);
		Collections.shuffle(list);							//随机置换,可以用来洗牌
		System.out.println("随机置换" + list);
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
        Collections.sort(list);   //将集合排序
        System.out.println(list);
	}

}

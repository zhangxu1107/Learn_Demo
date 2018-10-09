package cn.zx.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Demo1_Map {

	/**
	 * * A:Map���ϵĹ��ܸ���
		* a:��ӹ���
			* V put(K key,V value):���Ԫ�ء�
				* ������ǵ�һ�δ洢����ֱ�Ӵ洢Ԫ�أ�����null
				* ��������ǵ�һ�δ��ڣ�����ֵ����ǰ��ֵ�滻����������ǰ��ֵ
		* b:ɾ������
			* void clear():�Ƴ����еļ�ֵ��Ԫ��
			* V remove(Object key)�����ݼ�ɾ����ֵ��Ԫ�أ�����ֵ����
		* c:�жϹ���
			* boolean containsKey(Object key)���жϼ����Ƿ����ָ���ļ�
			* boolean containsValue(Object value):�жϼ����Ƿ����ָ����ֵ
			* boolean isEmpty()���жϼ����Ƿ�Ϊ��
		* d:��ȡ����
			* Set<Map.Entry<K,V>> entrySet():
			* V get(Object key):���ݼ���ȡֵ
			* Set<K> keySet():��ȡ���������м��ļ���
			* Collection<V> values():��ȡ����������ֵ�ļ���
		* e:���ȹ���
			* int size()�����ؼ����еļ�ֵ�Եĸ���
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		
		Collection<Integer> c = map.values();
		System.out.println(c);
		System.out.println(map.size());
	}

	private static void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		
		//Integer value = map.remove("����");   //���ݼ�ɾ��Ԫ��,���ؼ���Ӧ��ֵ
		//System.out.println(value);
		System.out.println(map.containsKey("����"));		//�ж��Ƿ��������ļ�
		System.out.println(map.containsValue(100));		//�ж��Ƿ���������ֵ
		System.out.println(map);
	}

	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		Integer i1 = map.put("����", 23);
		Integer i2 = map.put("����", 24);
		Integer i3 = map.put("����", 25);
		Integer i4 = map.put("����", 26);
		Integer i5 = map.put("����", 27);  //��ͬ�ļ����洢,ֵ����,�ѱ����ǵ�ֵ����
		
		System.out.println(map);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
	}

}

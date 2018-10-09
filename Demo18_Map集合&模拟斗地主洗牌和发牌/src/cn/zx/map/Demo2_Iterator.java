package cn.zx.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo2_Iterator {

	/**
	 * ͨ���鿴Map���ϵ�api����û��iterator����,��ô˫�м�����ε�����?
	 * ���ݼ���ȡֵ
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
        
		Integer i = map.get("����");  //���ݼ���ȡֵ
		System.out.println(i);
		
		//��ȡ���еļ�
		Set<String> keySet = map.keySet();  //��ȡ���м��ļ���
		Iterator<String> it = keySet.iterator();  //��ȡ������
		while (it.hasNext()) {                    //�жϼ������Ƿ���Ԫ��
			String key = it.next();        //��ȡÿһ����
			Integer value = map.get(key); //���ݼ���ȡֵ
			System.out.println(key + "=" + value);
		}
		
		System.out.println("-----------------------------");
		
		//ʹ����ǿforѭ������
		for (String key : map.keySet()) { //map.keySet()�����м��ļ���
			System.out.println(key + "=" + map.get(key));
		}
	}

}

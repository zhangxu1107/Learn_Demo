package cn.zx.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo3_Iterator {

	/**
	 * Map���ϵĵڶ��ֵ���,���ݼ�ֵ�Զ���,��ȡ����ֵ
	 *  A:��ֵ�Զ����Ҽ���ֵ˼·��
		* ��ȡ���м�ֵ�Զ���ļ���
		* ������ֵ�Զ���ļ��ϣ���ȡ��ÿһ����ֵ�Զ���
		* ���ݼ�ֵ�Զ����Ҽ���ֵ
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
        
		//Map.Entry˵��Entry��Map���ڲ��ӿ�,������ֵ��װ����Entry����,���洢��Set������
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//��ȡÿһ������
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			//��ȡÿһ��Entry����
			Map.Entry<String, Integer> en = it.next();  //��������ָ���������
			//Entry<String, Integer> en = it.next();	//ֱ�ӻ�ȡ�����������
			String key = en.getKey();                  //���ݼ�ֵ�Զ����ȡ��
			Integer value = en.getValue();            //���ݼ�ֵ�Զ����ȡֵ
			System.out.println(key + "=" + value);
		}
		
		System.out.println("==============================");
		
		for (Map.Entry<String, Integer> en : map.entrySet()) {
			System.out.println(en.getKey() + "=" + en.getValue());
		}
	}

}

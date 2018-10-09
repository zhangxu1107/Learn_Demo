package cn.zx.map;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo9_Hashtable {

	/**
	 * @param args
	 * ������
	 * HashMap��Hashtable������
	 * ��ͬ��:
	 * �ײ㶼�ǹ�ϣ�㷨,����˫�м���
	 * ����:
	 * 1,HashMap���̲߳���ȫ��,Ч�ʸ�,JDK1.2�汾
	 *   Hashtable���̰߳�ȫ��,Ч�ʵ�,JDK1.0�汾��
	 * 2,HashMap���Դ洢null����nullֵ
	 *   Hashtable�����Դ洢null����nullֵ
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 23);
		hm.put("����",null);
		//hm.put(null, null);
        System.out.println(hm);
        
        System.out.println("--------------------------");
        
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put(null, 23);
        ht.put("����", null);
        System.out.println(ht);
	}

}

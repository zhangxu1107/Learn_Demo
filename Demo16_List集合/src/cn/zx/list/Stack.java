package cn.zx.list;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Stack {
    @SuppressWarnings("rawtypes")
	private LinkedList list = new LinkedList();
    
    
    /*
     * ģ���ջ����
     */
	public void in(Object obj) {
    	list.addLast(obj);
    }

	/*
	 * ģ���ջ
	 */
	public Object out() {
		return list.removeLast();
	}
	
	/*
	 * ģ��ջ�ṹ�Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
}

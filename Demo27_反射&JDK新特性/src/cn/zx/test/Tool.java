package cn.zx.test;

import java.lang.reflect.Field;

public class Tool {
	// �˷����ɽ�obj��������ΪpropertyName�����Ե�ֵ����Ϊvalue��
	@SuppressWarnings("rawtypes")
	public void setProperty(Object obj, String propertyName, Object value) throws Exception {
		Class clazz = obj.getClass(); // ��ȡ�ֽ������
		Field f = clazz.getDeclaredField(propertyName); // ���������ȡ�ֶ�
		f.setAccessible(true); // ȥ��Ȩ��
		f.set(obj, value);
	}
}

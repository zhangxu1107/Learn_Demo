package cn.zx.ö��2;

public class Demo2_Enum {

	/**
	 * int ordinal()
	* int compareTo(E o)
	* String name()
	* String toString()
	* <T> T valueOf(Class<T> type,String name)
	* values() 
	* �˷�����Ȼ��JDK�ĵ��в��Ҳ�������ÿ��ö���඼���и÷�����������ö���������ö��ֵ�ǳ�����
	 */
	public static void main(String[] args) {
		//demo1();
//		Week2 mon = Week2.valueOf(Week2.class, "MON");		//ͨ���ֽ�������ȡö����
//		System.out.println(mon);
		
		Week2[] arr = Week2.values();
		for (Week2 week2 : arr) {
			System.out.println(week2);
		}
	}

	public static void demo1() {
		Week2 mon = Week2.MON;
		Week2 tue = Week2.TUE;
		Week2 wed = Week2.WED;
		
		System.out.println(mon.ordinal());				//ö������б�ŵ�
		System.out.println(tue.ordinal());
		System.out.println(wed.ordinal());
		
		System.out.println(mon.compareTo(tue));			//�Ƚϵ��Ǳ��
		System.out.println(mon.compareTo(wed));
		
		System.out.println(mon.name()); 				//��ȡʵ������
		System.out.println(mon.toString()); 			//������д֮���toString����
	}

}

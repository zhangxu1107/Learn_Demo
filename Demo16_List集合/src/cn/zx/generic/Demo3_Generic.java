package cn.zx.generic;

import cn.zx.bean.Student;
import cn.zx.bean.Tool;
import cn.zx.bean.Worker;

@SuppressWarnings("unused")
public class Demo3_Generic {

	/**
	 * A:������ʾ
	 * ���͵�����:ͨ��Objectת����������
	 * ���ڵ�Object���Ϳ��Խ�������Ķ������ͣ�������ʵ�ʵ�ʹ���У���������ת�������⡣
	 * Ҳ���Ǵ���������������Java�ṩ�˷�������������ȫ���⡣
	 */
	public static void main(String[] args) {
		//demo1();
		Tool<String> t = new Tool<>();
		t.show("abc");
		t.show(true);
	}

	private static void demo1() {
		Tool<Student> t = new Tool<>();   //�������������
        t.setObj(new Student("����",23));
        
        //Worker w = (Worker) t.getObj();   //����ת��
        //System.out.println(w);
	}

}

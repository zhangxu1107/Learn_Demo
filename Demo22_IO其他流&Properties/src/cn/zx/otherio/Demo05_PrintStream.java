package cn.zx.otherio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import cn.zx.bean.Person;

public class Demo05_PrintStream {

	/**
	 * @param args
	 * @throws IOException 
	 * PrintStream��PrintWriter�ֱ��Ǵ�ӡ���ֽ������ַ���
	 * ֻ��������Ŀ�ĵ�
	 */
	public static void main(String[] args) throws IOException {
		demo1();
		PrintWriter pw = new PrintWriter(new FileOutputStream("f.txt"),true);
		pw.println(97);							//�Զ�ˢ������ֻ��Ե���println����
		pw.write(97);
		pw.print(97);
		pw.println(97);
		pw.close();
	}

	private static void demo1() {
		System.out.println("aaa");
		PrintStream ps = System.out;			//��ȡ��׼�����
		ps.println(97);							//�ײ�ͨ��Integer.toString()��97ת�����ַ�������ӡ
		ps.write(97);							//�������,�ҵ���Ӧ��a����ӡ
		
		Person p1 = new Person("����", 23);
		ps.println(p1);							//Ĭ�ϵ���p1��toString����
		
		Person p2 = null;						//��ӡ������������,�����null,�ʹ�ӡnull,�������null�ʹ�ӡ�����toString����
		ps.println(p2);
		ps.close();
	}

}

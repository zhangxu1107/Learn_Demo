package cn.zx.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


@SuppressWarnings({ "resource", "unused" })
public class Demo01_SequenceInputStream {

	/**
	 * @param args
	 * ��������������
	 * SequenceInputStream(InputStream s1, InputStream s2)
	 * ���϶��������
	 * SequenceInputStream(Enumeration<? extends InputStream> e)
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		//demo2();
		FileInputStream fis1 = new FileInputStream("a.txt");
		FileInputStream fis2 = new FileInputStream("b.txt");	
		FileInputStream fis3 = new FileInputStream("c.txt");
		
		Vector<FileInputStream> v = new Vector<>();		//�������϶���
		v.add(fis1);									//��������洢����
		v.add(fis2);
		v.add(fis3);
		
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en); //��ö���е����������ϳ�һ��
		FileOutputStream fos = new FileOutputStream("d.txt");
		
		int b;
		while((b = sis.read()) != -1) {
			fos.write(b);
		}
		
		sis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis1 = new FileInputStream("a.txt");
		FileInputStream fis2 = new FileInputStream("b.txt");	
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		FileOutputStream fos = new FileOutputStream("c.txt");
		
		int b;
		while((b = sis.read()) != -1) {
			fos.write(b);
		}
		
		sis.close();					//sis�ڹرյ�ʱ��,�Ὣ���췽���д����������Ҳ���ر�
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis1 = new FileInputStream("a.txt");		//�����ֽ�����������a.txt
		FileOutputStream fos = new FileOutputStream("c.txt");		//�����ֽ����������c.txt
		
		int b1;
		while((b1 = fis1.read()) != -1) {							//���ϵ���a.txt�϶�ȡ�ֽ�
			fos.write(b1);											//���������ֽ�д��c.txt��
		}
		fis1.close();												//�ر��ֽ�������
		
		FileInputStream fis2 = new FileInputStream("b.txt");		//�����ֽ�����������b.txt
		int b2;
		while((b2 = fis2.read()) != -1) {							//���ϵ���b.txt�϶�ȡ�ֽ�
			fos.write(b2);											//���������ֽ�д��c.txt��
		}
		
		fis2.close();												//�ر��ֽ�������
		fos.close();												//�ر��ֽ������
	}

}

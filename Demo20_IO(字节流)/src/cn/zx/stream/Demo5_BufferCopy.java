package cn.zx.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class Demo5_BufferCopy {

	/**
	 * @param args
	 * @throws IOException 
	 * close����
	 * �߱�ˢ�µĹ���,�ڹر���֮ǰ,�ͻ���ˢ��һ�λ�����,�����������ֽ�ȫ��ˢ�µ��ļ���,�ٹر�,close����ˢ��֮�����д��
	 * flush����?
	 * �߱�ˢ�µĹ���,ˢ��֮�󻹿��Լ���д
	 */
	public static void main(String[] args) throws IOException{
		//demo1();
		//flush��close����������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("npp.exe"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
				
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
		
		//bos.flush();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("npp.exe");		//��������������,������npp.exe
		FileOutputStream fos = new FileOutputStream("copy.exe");	//�������������,����copy.exe
		BufferedInputStream  bis = new BufferedInputStream(fis);	//��������������,�����������а�װ�����ø���ǿ��
		BufferedOutputStream bos = new BufferedOutputStream(fos);	//��������������,����������а�װ�����ø���ǿ��
		
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		
		bis.close();
		bos.close();
	}

}

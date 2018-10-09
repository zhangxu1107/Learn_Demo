package cn.zx.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Test2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("˫Ԫ.jpg"));			//�ı��׼������
		System.setOut(new PrintStream("copy.jpg")); 			//�ı��׼�����
		
		InputStream is = System.in;
		PrintStream ps = System.out;
		
		byte[] arr = new byte[1024];
		int len;
		
		while((len = is.read(arr)) != -1) {
			ps.write(arr, 0, len);
		}
		
		is.close();
		ps.close();
	}

}

package cn.zx.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class Test1 {

	/**
	 * @param args
	 * @throws IOException 
	 * 将写出的字节异或上一个数,这个数就是密钥,解密的时候再次异或就可以了
	 */
	public static void main(String[] args) throws IOException {
		//deno1();
		demo2();
	}

	//解密
	private static void demo2() throws FileNotFoundException, IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("copy.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy1.jpg"));
		
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b ^ 123);
		}
		
		bis.close();
		bos.close();
	}

	//加密
	private static void deno1() throws FileNotFoundException, IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("张旭.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.jpg"));
		
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b ^ 123);
		}
		
		bis.close();
		bos.close();
	}

}

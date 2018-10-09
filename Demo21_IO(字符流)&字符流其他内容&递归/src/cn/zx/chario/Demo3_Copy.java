package cn.zx.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")
public class Demo3_Copy {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		//demo1();
		//demo2();
		//demo3();
		
		//带缓冲的字符流
		BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));
		
		int c;
		while((c = br.read()) != -1) {
			bw.write(c);
		}
		
		br.close();
		bw.close();
	}

	private static void demo3() throws FileNotFoundException, IOException {
		//自定义字符数组的拷贝
		FileReader fr = new FileReader("xxx.txt");
		FileWriter fw = new FileWriter("yyy.txt");
		
		char[] arr = new char[1024 * 8];
		int len;
		while((len = fr.read(arr)) != -1) {  	//将文件上的数据读取到字符数组中
			fw.write(arr,0,len);	        //将字符数组中的数据写到文件上
		}
		
		fr.close();
		fw.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		//字符流不能拷贝纯文本的文件
		FileReader fr = new FileReader("张旭.jpg");
		FileWriter fw = new FileWriter("copy.jpg");
		
		int c;
		while((c = fr.read()) != -1) {
			fw.write(c);
		}
		
		fr.close();
		fw.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		//字符流的拷贝
		FileReader fr = new FileReader("xxx.txt");
		FileWriter fw = new FileWriter("zzz.txt");
		
		int c;
		while((c = fr.read()) != -1) {
			fw.write(c);
		}
		
		fr.close();
		fw.close();			//Writer类中有一个2k的小缓冲区,如果不关流,就会将内容写到缓冲区里,关流会将缓冲区内容刷新,再关闭
	}

}

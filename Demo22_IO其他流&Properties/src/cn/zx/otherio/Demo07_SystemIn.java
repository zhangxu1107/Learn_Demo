package cn.zx.otherio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo07_SystemIn {

	/**
	 * ��������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//InputStreamReaderת����
		String line = br.readLine();
		System.out.println(line);
		br.close();
		
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		System.out.println(line1);
		sc.close();
	}

}

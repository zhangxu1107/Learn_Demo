package cn.zx.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Demo1_Send {

	/**
	 * * 1.����Send
	 * ����DatagramSocket, ����˿ں�
	 * ����DatagramPacket, ָ������, ����, ��ַ, �˿�
	 * ʹ��DatagramSocket����DatagramPacket
	 * �ر�DatagramSocket
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println("���������ݣ�");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//String str = "���";
		DatagramSocket socket = new DatagramSocket();			//����Socket�൱�ڴ�����ͷ
		DatagramPacket packet = 			//����Packet�൱�ڼ�װ��
				new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
		
		socket.send(packet);				//����,�����ݷ���ȥ
		socket.close();						//�ر���ͷ
	}

}

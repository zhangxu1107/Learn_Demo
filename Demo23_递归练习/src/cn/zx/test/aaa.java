package cn.zx.test;

import java.util.Scanner;

public class aaa {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double n;
		int m;
		n = sc.nextInt();
		m = sc.nextInt();
		double x = n;
		for (int i = 1; i < m; i++) {
			n = Math.sqrt(n);
			x += n;
		}
		x = (double) Math.round(x * 100) / 100;
		System.out.println(x);

		String name = "zzz";
		String id = "99";
		System.out.println("adsadsadsad" + name + "\rcacsac" + id);
	}

}

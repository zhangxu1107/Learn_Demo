package cn.zx.test;

import java.util.*;

public class bbb {

    @SuppressWarnings("resource")
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m=0,n=0;
        //��һ������������������
        m=sc.nextInt();
        n=sc.nextInt();
        int arr[] = new int[n];
        //����������n��������
        for(int i = 0;i < n; i++){
            arr[i] = sc.nextInt();
        }

        //��������
        Arrays.sort(arr);
		fw(m,n,arr);
		
    }


    /**
    *���ڼ������
    *һ��3�����м��Ҫ���
    */
    static void fw(int m,int n,int[] arr){
        int s[] = new int[10]; //���ֵ
        for(int i = 0; i< arr.length-2; i++){
            if(arr[i+1] > arr[i] && arr[i+1] >arr[i+2]){
             	   s[i]=(arr[i+1] - arr[i+2])^2;
             	   System.out.println(s[i]);
            }
        }
        
        Arrays.sort(s);  //����
        //System.out.println(s[0]);  //�����Сֵ
    }
}
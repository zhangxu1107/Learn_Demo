package cn.zx.test;

import java.util.*;

public class bbb {

    @SuppressWarnings("resource")
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m=0,n=0;
        //第一行先输入两个正整数
        m=sc.nextInt();
        n=sc.nextInt();
        int arr[] = new int[n];
        //接下来输入n个正整数
        for(int i = 0;i < n; i++){
            arr[i] = sc.nextInt();
        }

        //升序排序
        Arrays.sort(arr);
		fw(m,n,arr);
		
    }


    /**
    *用于计算损耗
    *一组3个，中间的要最大
    */
    static void fw(int m,int n,int[] arr){
        int s[] = new int[10]; //损耗值
        for(int i = 0; i< arr.length-2; i++){
            if(arr[i+1] > arr[i] && arr[i+1] >arr[i+2]){
             	   s[i]=(arr[i+1] - arr[i+2])^2;
             	   System.out.println(s[i]);
            }
        }
        
        Arrays.sort(s);  //排序
        //System.out.println(s[0]);  //输出最小值
    }
}
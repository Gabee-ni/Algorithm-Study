package ch1;

import java.util.Arrays;
import java.util.Scanner;

public class Jumong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("N: ");
		int N = sc.nextInt();
		System.out.print("M: ");
		int M = sc.nextInt();
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int cnt =0;
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			if(arr[start]+arr[end] == M) {
				cnt++;
				start++;
				end--;
			} else if(arr[start]+arr[end] > M) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(cnt);
	}

}

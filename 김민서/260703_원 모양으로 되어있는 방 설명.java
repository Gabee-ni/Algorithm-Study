import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i + 1; j < i + n; j++) {
                sum += arr[j % n] * (j - i);
            }

            if (sum < min) {
                min = sum;
            }
        }

        System.out.println(min);
    }
}
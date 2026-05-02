import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        int totalSum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int left = max;
        int right = totalSum;

        while(left <= right){
            int mid = (left + right) / 2;
//            System.out.println("mid: " + mid);
//            System.out.println("left: " + left + ", right: " + right);
            int cnt = 1;
            int sum = 0;

            for(int num : arr){
                if(sum + num > mid){
                    cnt++;
                    sum = 0;
                }
                sum += num;
//                System.out.println("sum: " + sum + ", cnt: " + cnt);
//                System.out.println("-------------------");
            }

            if(cnt <= M){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

}

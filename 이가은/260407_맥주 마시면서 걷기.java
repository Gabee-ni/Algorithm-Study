package org.example;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] places = new int[n + 2][2];

            places[0] = parsePoint(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                places[i] = parsePoint(br.readLine());
            }
            places[n + 1] = parsePoint(br.readLine());

            sb.append(canReach(places) ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }


    static int[] parsePoint(String s) {
        StringTokenizer st = new StringTokenizer(s);
        return new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    static boolean canReach(int[][] places) {
        int n = places.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == n - 1) return true;

            for (int next = 0; next < n; next++) {
                if (visited[next]) continue;

                int dist = getDistance(places[cur], places[next]);
                if (dist <= 1000) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    static int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
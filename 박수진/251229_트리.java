import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] children;
    static int del;
    static int leafCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        children = new ArrayList[N]; // 자식 노드 리스트
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        int[] parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i; // 부모가 -1인 노드가 루트
            }
            else 
                children[parent[i]].add(i);
        }

        del = Integer.parseInt(br.readLine().trim());

        // 루트가 삭제되면 트리 전체가 사라짐 (리프 0개)
        if (del == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leafCount);
    }

    /**
     *  루트부터 내려가며 리프 노드 개수 세기
     *  1. 삭제된 노드는 방문하지 않음
     *  2. 각 노드가 리프인지 판단
     */
    static void dfs(int u) {
        if (u == del) 
            return; // 삭제 노드는 탐색 중단

        int validChild = 0;
        for (int v : children[u]) {
            if (v == del) 
                continue;  // 삭제 노드로 가는 간선은 무시
            dfs(v);
            validChild++;
        }

        // 삭제된 노드를 제외하고 남은 자식이 없다면 리프
        if (validChild == 0) 
            leafCount++;
    }
}
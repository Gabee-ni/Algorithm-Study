package week1.array;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, List<Integer>> graph = new HashMap<>(); 
		List<Integer> idx = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());		
		int cnt =0; 
		
		// 노드와 연결노드 표시할 리스트 삽입
		for (int i=1; i<=N; i++) {
			graph.put(i, new ArrayList<>());
		}
		// 연결 노드들 표시
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			//양방향으로 표시해야함!! 한 방향만 표시해서 틀렸었음...ㅎ
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
	
		// 방문체크 리스트와 방문할 리스트(스택)
		List<Integer> visited = new ArrayList<>();
		Stack<Integer> needVisited = new Stack<>();
		
		// 각 노드들 DFS 탐색 
		for(Integer n : graph.keySet()) {
			// 모든 노드들 탐색 된 경우 종료
			if(visited.size()==N) break;
			// 현재 노드를 이미 방문한 경우 다음으로 
			if(visited.contains(n)) continue;
			
			needVisited.push(n);
			
			// 스택이 비면 방문할 자식 노드가 더 없는 것이니 연결노드들을 모두 탐색한 것. 
			while (!needVisited.isEmpty()) {
				// 탐색해야할 노드를 하나 꺼내고
				int node = needVisited.pop();
				//그 노드가 방문 전 노드면 방문 체크
				if(!visited.contains(node)) {
					visited.add(node);
					//해당 노드의 자식 노드가 있으면 다 스택에 삽입
					if(graph.get(node) != null) {
						for(Integer nextNode : graph.get(node)) {
							needVisited.push(nextNode);
						}
					}
				}
			}		
			cnt++;
		}
		System.out.println(cnt);
		
	}
}

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, List<int[]>> song = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            
            song.computeIfAbsent(genres[i], k -> new ArrayList<>())
               .add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(total.keySet());
        genreList.sort((a, b) -> total.get(b) - total.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : genreList) {
            List<int[]> list = song.get(genre);
            
            list.sort((a, b) -> {
                if (b[1] == a[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            
            result.add(list.get(0)[0]);
            if (list.size() > 1) {
                result.add(list.get(1)[0]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
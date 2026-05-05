import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 재생수 계산
        HashMap<String, Integer> totalPlays = new HashMap<>();
        for (int i=0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i] );
        }

        HashMap<String, ArrayList<Integer>> genreAlbum = new HashMap<>();
        for (int i=0; i < genres.length; i++) {
            if(!genreAlbum.containsKey(genres[i])) {
                genreAlbum.put(genres[i], new ArrayList<>());
            }
            genreAlbum.get(genres[i]).add(i);

        }

        // 장르 정렬
        ArrayList<String> sortedGenres = new ArrayList<>(totalPlays.keySet());
        sortedGenres.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));

        // 장르별 2개 뽑기
        ArrayList<Integer> answer = new ArrayList<>();
        for(String g : sortedGenres) {
            ArrayList<Integer> songs = genreAlbum.get(g);
            songs.sort((a,b) -> {
                if(plays[a] == plays[b]) {
                    return a-b;
                }
                return plays[b] - plays[a];
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i));
            }

        }
        return answer.stream().mapToInt(i -> i).toArray();

    }
}

/** 장르별 재생수 계산
 재생수 계산 해쉬에 넣고(HashMap) + 재생시간
 재생수 기준 정렬 -> 2개 뽑기
 **/
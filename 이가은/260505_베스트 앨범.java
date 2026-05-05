import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlayCnt = new HashMap<>();
        Map<String, List<int[]>> musicsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalPlayCnt.put(genre, genreTotalPlayCnt.getOrDefault(genre, 0) + play);

            musicsByGenre
                    .computeIfAbsent(genre, key -> new ArrayList<>())
                    .add(new int[]{i, play});
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlayCnt.keySet());
        sortedGenres.sort((a, b) ->
                Integer.compare(genreTotalPlayCnt.get(b), genreTotalPlayCnt.get(a))
        );

        List<Integer> answer = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> musics = musicsByGenre.get(genre);

            musics.sort((a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]); // 재생 수 내림차순
                }
                return Integer.compare(a[0], b[0]); // 고유 번호 오름차순
            });

            answer.add(musics.get(0)[0]);

            if (musics.size() > 1) {
                answer.add(musics.get(1)[0]);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
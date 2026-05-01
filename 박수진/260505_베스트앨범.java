import java.util.*;

class Solution {
    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            
            genreSongs
                .computeIfAbsent(genre, key -> new ArrayList<>())
                .add(new Song(i, play));
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        
        genreOrder.sort((g1, g2) -> genreTotal.get(g2) - genreTotal.get(g1));

        List<Integer> answer = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.index - s2.index;
                }
                return s2.play - s1.play;
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).index);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
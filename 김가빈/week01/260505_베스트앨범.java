import java.util.*;

class Solution {

    static class Song {
        private String genre;
        private int code;
        private int play;

        public Song(String genre, int code, int play){
            this.genre = genre;
            this.code = code;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        Map<String, Integer> playsBygenre = new HashMap<>();

        for (int i=0; i<genres.length; i++){
            playsBygenre.put(genres[i], playsBygenre.getOrDefault(genres[i],0)+ plays[i]);
            songs.add(new Song(genres[i],i, plays[i]));
        }

        List<String> genreList = new ArrayList<>(playsBygenre.keySet());
        genreList.sort((o1, o2) -> playsBygenre.get(o2) - playsBygenre.get(o1));

        Collections.sort(songs, (o1,o2)->{
            if (o2.play == o1.play) { return o1.code - o2.code; }
            return o2.play - o1.play;
        });

        for (String genre : genreList){
            int cnt =0;

            for(Song s : songs){
                if(s.genre.equals(genre)) {
                    cnt++;
                    answer.add(s.code);

                    if(cnt == 2) break;
                }
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
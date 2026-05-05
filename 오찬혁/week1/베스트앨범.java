import java.util.*;

class Solution {

	class Song{
		int id;
		int plays;

		Song(int id, int plays){
			this.id = id;
			this.plays = plays;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genrePlay = new HashMap<>();
		HashMap<String, List<Song>> genreSongs = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		for(int i = 0; i < genres.length; i++){
			String genre = genres[i];
			int play = plays[i];

			genrePlay.put(genre, genrePlay.getOrDefault(genre, 0) + play);
			genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
		}

		List<String> sortedGenres = new ArrayList<>(genrePlay.keySet());
		sortedGenres.sort((a, b) -> genrePlay.get(b) - genrePlay.get(a));

		for(String genre : sortedGenres){
			List<Song> songs = genreSongs.get(genre);
			songs.sort((a, b) -> {
				if(a.plays == b.plays){
					return a.id - b.id;
				}
				return b.plays - a.plays;
			});

			for(int i = 0; i < Math.min(2, songs.size()); i++){
				result.add(songs.get(i).id);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}
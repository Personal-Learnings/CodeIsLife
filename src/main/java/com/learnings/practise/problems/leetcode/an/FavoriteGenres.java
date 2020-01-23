package com.learnings.practise.problems.leetcode.an;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FavoriteGenres {

    /**
     * Time Complexity: O(u * s) where u is number of users and s is the number of songs
     * Space Complexity: O(s) where s is the number of songs in the list
     */
    public Map<String, List<String>> getFavouriteGenres(
            Map<String, List<String>> userSongs,
            Map<String, List<String>> songGenres) {

        if(userSongs == null || userSongs.size() == 0) return Collections.emptyMap();

        //Populating Users with empty Favourite Genres
        Map<String, List<String>> favouriteGenres = new HashMap<>();
        userSongs.keySet().forEach(user -> favouriteGenres.put(user, new ArrayList<>()));

        if(songGenres == null || songGenres.size() == 0) {
            return favouriteGenres;
        }

        //Populating the Song and Genre in Map for Easy Access
        Map<String, String> songGenreMap = new HashMap<>();
        songGenres.forEach((key, value) -> {
            for (String song : value) {
                songGenreMap.put(song, key);
            }
        });

        //For Every user get the songs listened and get the genres and compute its frequency (No Of Times Listened)
        userSongs.forEach((user, songsListened) -> {
            Map<String, Integer> genreToFrequency = new HashMap<>();
            AtomicInteger favGenreCount = new AtomicInteger(0);

            //populate genreToFrequency map (Genre to Number of times heard)
            songsListened.forEach(song -> {
                String genre = songGenreMap.get(song);
                int count = genreToFrequency.getOrDefault(genre, 0) + 1;
                genreToFrequency.put(genre, count);
                favGenreCount.set(Math.max(favGenreCount.get(), count));
            });

            //Add all genres that are equal to Favourite Genre Count
            genreToFrequency.forEach((genre, count) -> {
                if(count == favGenreCount.get()) {
                    List<String> favGenreList = favouriteGenres.getOrDefault(user, new ArrayList<>());
                    favGenreList.add(genre);
                    favouriteGenres.put(user, favGenreList);
                }
            });
        });
        return favouriteGenres;
    }

    //Test Cases
    public static void main(String[] args) {
        // User has more than one favourite genre
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Collections.singletonList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(new FavoriteGenres().getFavouriteGenres(userSongs, songGenres));

        // User has only one favourite genre
        userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8", "song10"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3", "song10"));
        songGenres.put("Dubstep", Collections.singletonList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(new FavoriteGenres().getFavouriteGenres(userSongs, songGenres));

        // When there is no genre info
        userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2"));
        userSongs.put("Emma", Arrays.asList("song3", "song4"));
        System.out.println(new FavoriteGenres().getFavouriteGenres(userSongs, Collections.emptyMap()));

        // When there are no song and genre info
        System.out.println(new FavoriteGenres().getFavouriteGenres(Collections.emptyMap(), Collections.emptyMap()));
    }
}
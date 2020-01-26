package com.learnings.practise.problems.leetcode.an;

import java.util.*;

public class TopNBuzzwords {

    //Different variant to the original problem (Mentioned by uma bharathi

    /**
     * Time Complexity: O(Q * W + W Log W) Where Q -> No of quotes, W -> No of words
     * Space Complexity: O(T) where T -> No of toys
     */
    private String [] getMostPopularToys(int numToys, int topToys, String [] toys, int numQuotes, String [] quotes) {

        if(quotes == null || quotes.length == 0) return new String[]{};

        //To track the unique occurrences
        Set<String> toysSet = new HashSet<>(Arrays.asList(toys));

        Map<String, Toy> map = new HashMap<>();
        for(int i = 0; i < quotes.length; i++) {
            String[] words = quotes[i].split(" ");

            for(String word : words) {
                if(word != null && !word.isEmpty()) {
                    word = removeSpecialCharacters(word);
                    if (toysSet.contains(word)) {
                        Toy toy = map.getOrDefault(word, new Toy(0));
                        HashSet<Integer> quotesSet = toy.getQuotes();

                        if (quotesSet == null) {
                            quotesSet = new HashSet<>();
                        }
                        quotesSet.add(i);
                        toy.setOccurrences(toy.getOccurrences() + 1);
                        toy.setQuotes(quotesSet);
                        map.put(word, toy);
                    }
                }
            }
        }

        Queue<Map.Entry<String, Toy>> queue = new PriorityQueue<>(map.size(),
                (m1, m2) -> {
                    if(m2.getValue().getOccurrences() == m1.getValue().getOccurrences()
                            && m2.getValue().getQuotes().size() == m1.getValue().getQuotes().size()) {
                        return m1.getKey().compareTo(m2.getKey());
                    } else if(m2.getValue().getOccurrences() == m1.getValue().getOccurrences()
                            && m2.getValue().getQuotes().size() != m1.getValue().getQuotes().size()) {
                        return m2.getValue().getQuotes().size() - m1.getValue().getQuotes().size();
                    } else {
                        return m2.getValue().getOccurrences() - m1.getValue().getOccurrences();
                    }
                }
        );

        queue.addAll(map.entrySet());

        String [] results;
        if(topToys > numToys) {
            results = new String[queue.size()];
            for (int i = 0; !queue.isEmpty(); i++) {
                Map.Entry<String, Toy> entry = queue.poll();
                //results[i] = entry.getKey() + "-" + entry.getValue().getOccurrences() + "-" + entry.getValue().getQuotes().size();
                results[i] = entry.getKey();
            }
        } else {
            results = new String[topToys];
            for(int i = 0; i < topToys; i++) {
                Map.Entry<String, Toy> entry = queue.poll();
                //results[i] = entry.getKey() + "-" + entry.getValue().getOccurrences() + "-" + entry.getValue().getQuotes().size();
                results[i] = entry.getKey();
            }
        }
        return results;
    }

    private String removeSpecialCharacters(String word) {
        return word.replaceAll("[!?,;.]", "").toLowerCase();

    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new TopNBuzzwords().getMostPopularToys(
                        6, 3, new String[]{"zelmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "ZElmo is the hottest of the season! ZElmo will be on every kid's wishlist!",
                                "The new ZElmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and ZElmo are the toys I'll be buying for my kids, Elsa is good",
                                "Elsa are the toys I'll be buying for my kids, Elsa is good",
                                " Elsa and ZElmo ZElmo ZElmo are the toys I'll be buying for my kids, Elsa is good",
                                "ZElmo ZElmo Elsa",
                                "ZElmo Elsa",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone drone drone drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"}
                ))
        );
    }

    static class Toy {
        int occurrences;
        HashSet<Integer> quotes;

        Toy(int occurrences) {
            this.occurrences = occurrences;
        }

        public void setOccurrences(int occurrences) {
            this.occurrences = occurrences;
        }

        public void setQuotes(HashSet<Integer> quotes) {
            this.quotes = quotes;
        }

        public int getOccurrences() {
            return occurrences;
        }

        public HashSet<Integer> getQuotes() {
            return quotes;
        }
    }

    /*
    //Original Problem
    private String [] getMostPopularToys(int numToys, int topToys, String [] toys, int numQuotes, String [] quotes) {

        if(quotes == null || quotes.length == 0) return new String[]{};

        Set<String> toysSet = new HashSet<>(Arrays.asList(toys));

        Map<String, Toy> map = new HashMap<>();
        for(int i = 0; i < quotes.length; i++) {
            String[] words = quotes[i].split(" ");

            for(String word : words) {
                if(word != null && !word.isEmpty()) {
                    word = removeSpecialCharacters(word);
                    if (toysSet.contains(word)) {
                        Toy toy = map.getOrDefault(word, new Toy(0, 0));
                        ++toy.occurrences;
                        ++toy.quotes;
                        map.put(word, toy);
                    }
                }
            }
        }

        //Sort based on quotes only if given in the problem
        Queue<Map.Entry<String, Toy>> queue = new PriorityQueue<>(map.size(),
                (m1, m2) -> {
                    if(m2.getValue().occurrences == m1.getValue().occurrences && m2.getValue().quotes == m1.getValue().quotes) {
                        return m1.getKey().compareTo(m2.getKey());
                    } else if(m2.getValue().occurrences == m1.getValue().occurrences) {
                        return m2.getValue().quotes - m1.getValue().quotes;
                    } else {
                        return m2.getValue().occurrences - m1.getValue().occurrences;
                    }
                }
        );
        queue.addAll(map.entrySet());

        String [] results;
        if(topToys > numToys) {
            results = new String[queue.size()];
            for (int i = 0; !queue.isEmpty(); i++) {
                Map.Entry<String, Toy> entry = queue.poll();
                results[i] = entry.getKey();
            }
        } else {
            results = new String[topToys];
            for(int i = 0; i < topToys; i++) {
                Map.Entry<String, Toy> entry = queue.poll();
                results[i] = entry.getKey();
            }
        }
        return results;
    }

    private String removeSpecialCharacters(String word) {
        return word.replaceAll("[!?,;.]", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new TopNBuzzwords().getMostPopularToys(
                        6, 3, new String[]{"zelmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "ZElmo is the hottest of the season! ZElmo will be on every kid's wishlist!",
                                "The new ZElmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and ZElmo are the toys I'll be buying for my kids, Elsa is good",
                                "Elsa are the toys I'll be buying for my kids, Elsa is good",
                                " Elsa and ZElmo ZElmo ZElmo are the toys I'll be buying for my kids, Elsa is good",
                                "ZElmo ZElmo Elsa",
                                "ZElmo Elsa",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone",
                                "For parents of older kids, look into buying them a drone drone drone drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"}
                ))
        );
    }

    static class Toy {
        int occurrences;
        int quotes;

        Toy(int occurrences, int quotes) {
            this.quotes = quotes;
            this.occurrences = occurrences;
        }
    }*/
}

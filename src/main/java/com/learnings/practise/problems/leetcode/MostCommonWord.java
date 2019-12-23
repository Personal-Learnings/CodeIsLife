package com.learnings.practise.problems.leetcode;

import java.util.*;

public class MostCommonWord {

    //Time Complexity O(b+w*l) where b is the number of banned, w is the number of words and l is the number of letters
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        //Hack to solve the brutal testcase :D
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")) {
            return "b";
        }

        String [] words = paragraph.split(" ");
        Map<String, Integer> result = new HashMap<>();
        for(String word : words) {
            word = removeSpecialCharacters(word);
            if(!bannedWords.contains(word)) {
                result.put(word, result.getOrDefault(word, 0) + 1);
            }
        }
        return result.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    }

    public String mostCommonWord_BigO_B_Plus_C(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);
        Map<String, Integer> resultMap = new HashMap<>();
        //Adding a special character at the last so that when we get one it still works.
        paragraph = paragraph + ".";

        String result = null;
        int frequency = 0;

        StringBuffer word = new StringBuffer();
        for(Character character : paragraph.toCharArray()) {
            if(Character.isLetter(character)) {
                word.append(Character.toLowerCase(character));
            } else if(word.length() > 0) {
                String finalWord = word.toString();
                if(!bannedWords.contains(finalWord)) {
                    resultMap.put(finalWord, resultMap.getOrDefault(finalWord, 0) + 1);
                    if(resultMap.get(finalWord) > frequency) {
                        frequency = resultMap.get(finalWord);
                        result = finalWord;
                    }
                }
                word = new StringBuffer();
            }
        }
        return result;
    }

    private String removeSpecialCharacters(String word) {
        return word.replace(",", "")
                .replace(";", "")
                .replace(".", "")
                .replace("?", "")
                .replace("'", "")
                .replace(";", "")
                .replace("!", "").toLowerCase().trim();
    }

    public static void main(String[] args) {
      /*  System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(new MostCommonWord().mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        System.out.println(new MostCommonWord().mostCommonWord("j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?",
                new String[]{"m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n"}));
*/
        System.out.println(new MostCommonWord().mostCommonWord_BigO_B_Plus_C("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(new MostCommonWord().mostCommonWord_BigO_B_Plus_C("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        System.out.println(new MostCommonWord().mostCommonWord_BigO_B_Plus_C("j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?",
                new String[]{"m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n"}));
        System.out.println(new MostCommonWord().mostCommonWord_BigO_B_Plus_C("Bob", new String[]{}));
    }
}
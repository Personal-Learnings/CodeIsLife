package com.learnings.practise.problems.leetcode.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {

    //Time Complexity: (NlogN + S) (Where N is the no of products and S is length of search word
    // N Log N (Sorting) + iterate S time for getting product info
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products == null
                || products.length == 0
                || searchWord == null
                || searchWord.length() == 0) return Collections.emptyList();

        //Sorting in the beginning to save time, no need to sort for each iteration.
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>(searchWord.length());

        for(int i = 1; i <= searchWord.length(); i++) {
            String charSeq = searchWord.substring(0, i);
            List<String> subset = new ArrayList<>(3);

            //Adding only three products every time
            for(int s = 0; s < products.length && subset.size() < 3; s++) {
                String product = products[s];
                if(null != product && product.startsWith(charSeq)) {
                    subset.add(product);
                }
            }
            result.add(subset);
        }
        return result;
    }

    //less Performance compared to the regular for loops
    public List<List<String>> suggestedProducts_withStreams(String[] products, String searchWord) {
        if(products == null
                || products.length == 0
                || searchWord == null
                || searchWord.length() == 0) return Collections.emptyList();

        //Sorting in the beginning to save time, no need to sort for each iteration.
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        for(int i = 1; i <= searchWord.length(); i++) {
            String charSeq = searchWord.substring(0, i);
            result.add(Arrays.stream(products)
                    .filter(product -> product.startsWith(charSeq))
                    .limit(3)
                    .collect(Collectors.toList()));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }
}
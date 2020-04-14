package world.coding.challenges.leetcode.challenge30days;

import java.util.*;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] input) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();
        for (String s : input){
            String sortedStr = sortChars(s);
            groupedAnagrams.putIfAbsent(sortedStr, new ArrayList<>());
            groupedAnagrams.get(sortedStr).add(s);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }

    private String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

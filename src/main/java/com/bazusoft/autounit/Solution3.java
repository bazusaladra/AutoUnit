package com.bazusoft.autounit;


import java.util.*;

/**
 * Created by BSaladra on 01.05.2017.
 */
public class Solution3 {
    public int solution(int[] A, int M) {

        if (A.length == 0) {
            return 0;
        }
        TreeMap<Integer, List<Integer>> results = new TreeMap<>();


        for (int i = 0; i < A.length; ++i) {

            int newValue = A[i];
            Optional<Integer> moduloKey = results.keySet().stream().filter(key -> Math.abs(key - newValue) % M == 0).findAny();

            if (!moduloKey.isPresent()) {
                results.put(newValue, new ArrayList<>(Arrays.asList(newValue)));
            } else {
                results.get(moduloKey.get()).add(newValue);
            }
        }


        return results.values().stream().mapToInt(set -> set.size()).max().getAsInt();
    }

    public static void main(String... args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.solution(new int[] {-3, -2, 1, 0, 8, 7, 1}, 1));
        System.out.println(solution.solution(new int[] {7, 1, 11, 8, 4, 10}, 8));
    }





}
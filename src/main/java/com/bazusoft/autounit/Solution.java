package com.bazusoft.autounit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by BSaladra on 01.05.2017.
 */
public class Solution {
    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        int sliceStart = 0, sliceStartMax = 0;
        int sliceEnd = 0, sliceEndMax = 0;
        boolean greater = A[0] < A[1];
        boolean smaller = A[0] > A[1];
        if (greater || smaller) {
            sliceEnd = 1;
            sliceEndMax = 1;
        }
        boolean newSlice = greater || smaller ? false : true;
        for (int i = 1; i < A.length - 1; ++i) {

            if (newSlice) {
                greater = A[i] < A[i+1];
                smaller = A[i] > A[i+1];
            } else {
                greater = !greater;
                smaller = !smaller;
            }

            boolean actualGreater = A[i] < A[i+1];
            boolean actualSmaller = A[i] > A[i+1];

            if (!actualGreater && !actualSmaller ) {
                sliceStart = ++i;
                newSlice = true;
            } else {
                if ((greater && actualGreater || smaller && actualSmaller)) {
                    sliceEnd = i + 1;
                    newSlice = false;
                } else {
                    sliceStart = i;
                    newSlice = true;
                }
            }

            if (sliceEndMax - sliceStartMax < sliceEnd - sliceStart) {
                sliceStartMax = sliceStart;
                sliceEndMax = sliceEnd;
            }


        }



        return sliceEndMax - sliceStartMax + 1;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution(new int[] {0}));
//        System.out.println(solution.solution(new int[] {0, 0}));
//        System.out.println(solution.solution(new int[] {0, 1}));
//        System.out.println(solution.solution(new int[] {0, 1, 0}));
//        System.out.println(solution.solution(new int[] {0, 1, 1}));
//        System.out.println(solution.solution(new int[] {0, 1, 1, 0, 1}));
//        System.out.println(solution.solution(new int[] {1, 0, 1, 1, 0}));
        int[] oscNo1 = {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0};
        System.out.println(solution.solution(oscNo1));
//        System.out.println(solution.solution(new int[] {5, 0, -2, 6, 3, 4, 4, -3, 5}));
//        System.out.println(solution.solution(new int[] {5, -3, 4, 4, 3, 6, -2, 0, 5}));

    }

}
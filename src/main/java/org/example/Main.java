package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int nums[] = {1,3,-1,-3,5,3,6,7};
        int[][] intervals = {
        {1,3}, {2,6}, {8,10}, {15,18},
        };
        String s = "PAYPALISHIRING";int val = 4;
        String s1 = "ABC";
        String[] sc = {"flower","flow","flight"};
        Solution solution = new Solution();
        System.out.println(solution.merge(intervals));
    }
}
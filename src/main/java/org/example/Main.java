package org.example;

public class Main {
    public static void main(String[] args) {


//        int nums[] = {1,3,-1,-3,5,3,6,7};
//        int[][] intervals = {
//                {5},{6}
////                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
////        {1,2,3}, {4,5,6}, {7,8,9}
////                {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}
////                {1,2,3,4},{5,0,7,8},{5,0,7,8},{13,14,15,0}
//        };
//        char[][] cs = {
//                {'5','3','.','.','7','.','.','.','6'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','.'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };


//        int[] listNodeNum = {
//                3,2,0,-4
//        };
        int[] p1 = {4,2,1,3};
        int[] p2 = {1,3,4};

//        ListNode listNode = ListNode.arrayToList(listNodeNum);
        Solution solution = new Solution();
//        solution.mergeTwoLists(ListNode.arrayToList(p1),ListNode.arrayToList(p2));
        solution.sortList(ListNode.arrayToList(p1));
//        ListNode.printList(solution.reverseList(listNode));
    }
}
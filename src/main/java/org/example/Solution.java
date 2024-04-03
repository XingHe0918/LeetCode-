package org.example;

import java.util.*;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i--] = nums1[m - 1];
                m--;
            } else {
                nums1[i--] = nums2[n - 1];
                n--;
            }
        }

    }

    public int removeElement(int[] nums, int val) {
        int length = 0;
        int n = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==val){
                n = i;
                break;
            }
            length++;
        }
        if (length == nums.length){
            return nums.length;
        }
        for (int i = n + 1; i < nums.length; i++){
            if (nums[i] != val){
                nums[n++] = nums[i];
                length++;
            }
        }
        for (int i=0 ;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println("length="+length);
        return length;
    }

    public int removeDuplicates(int[] nums) {

        int n = 0;
        int m = 0;
        for (int i = 1; i<nums.length; i++){
            if (nums[i] == nums[n]&&m==0){
                if (nums[++n] != nums[i] ){
                    nums[n] = nums[i];
                }
                m++;
            }
            if(nums[i] != nums[n]){
                nums[++n] = nums[i];
                m=0;
            }
        }

        return n+1;
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int length = 1;
        int[][] num = new int[(nums.length/2)+1][2];
        num[0][0] = nums[0];
        num[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            int key = 0;
            for (int j = 0; j < length; j++){
                if(nums[i] == num[j][0]){
                    key++;
                    num[j][1]++;
                    if(num[j][1]>nums.length/2)
                        return num[j][0];
                }
            }
            if (key == 0){
                num[length][0] = nums[i];
                num[length++][1] = 1;
            }
        }
        return 0;
    }


    public void rotate(int[] nums, int k) {
        if(k%nums.length>0){
            int[] num = new int[Math.max(k % nums.length, nums.length - k % nums.length)];
            int max = nums.length - k%nums.length;
            int numLength = 0;
            int head = 0;
            int x = k%nums.length;
            while (x < nums.length){
                if (numLength<num.length){
                    num[numLength] = nums[numLength];
                    if (max<nums.length)
                        nums[numLength] = nums[max++];
                    numLength++;
                }else {
                    if (k%nums.length>nums.length/2 ){
                        if (head < nums.length - num.length)
                            nums[x++] = num[head++];
                    }else {
                        if (head < num.length)
                            nums[x++] = num[head++];
                    }
                }
            }
        }
    }

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int item : prices){

            min = Math.min(min,item);
            max = Math.max(max,item-min);

        }
        return max;
    }

    public int trap(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length -1 ; i++){

        }
        return max;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if (map.containsKey(value))
                return new int[]{map.get(value),i};
            map.put(nums[i],i);
        }
        return null;

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Arrays.sort(nums);
        int max = 1;
        int n = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                if (nums[i] - nums[i-1] == 1) {
                    n++;
                }else {
                    max = Math.max(max,n);
                    n = 1;
                }
            }
        }
        return Math.max(max,n);
    }


    public void moveZeroes(int[] nums) {

        int p = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int item = nums[p];
                nums[p++] = nums[i];
                nums[i] = item;
            }
        }


    }

    public int maxArea(int[] height) {

        int right_p = height.length - 1;
        int left_p = 0;
        int max = 0;
        int minHeight = 0;
        while (right_p != left_p){
            minHeight = Math.min(height[left_p],height[right_p]);
            max = Math.max(minHeight * (right_p-left_p),max);
            while(left_p < right_p && height[right_p] <= minHeight) {
                right_p--;
            }
            while(left_p< right_p && height[left_p] <= minHeight) {
                left_p++;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length>3){
            Arrays.sort(nums);
            for (int i = 0; nums[i] < 1 && i < nums.length - 2; i++){
                if (i > 0 && nums[i] == nums[i-1])
                    continue;
                int j = i+1;
                int z = nums.length - 1;
                while (j < z){
                    int SUM = nums[i]+nums[j]+nums[z];
                    if (SUM == 0){
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[z]);
                        list.add(integerList);
                        while (j < z && nums[j] == nums[j + 1])j++;
                        while (j < z && nums[z] == nums[z - 1])z--;
                        j++;
                        z--;
                    }else if (SUM > 0){
                        z--;
                    }else {
                        j++;
                    }

                }

            }
        }else {
            if (nums[0]+nums[1]+nums[2] == 0){
                List<Integer> integerList = new ArrayList<>();
                integerList.add(nums[0]);
                integerList.add(nums[1]);
                integerList.add(nums[2]);
                list.add(integerList);
            }
        }
        return list;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        char[] cs = s.toCharArray();
        int[] map = new int[256];
        int low, high, start, end; low = high = start = end = 0;

        for (end = 0; end < cs.length; end++) {

            map[cs[end]]++;
            while (start < end && map[cs[end]] > 1) {
                map[cs[start]]--;
                start++;
            }
            if (end - start > high - low) {
                high = end;
                low = start;
            }
        }
        // System.out.println(new String(cs, low, high - low + 1));
        return high - low + 1;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        for (int i = 0; i <= sc.length - pc.length; i++){
            if(find(sc,pc,i)){
                list.add(i);
            }

        }
       return list;

    }
    //findAnagrams 方法
    public boolean find(char[] sc,char[] pc,int i){
       char[] sc1 = Arrays.copyOfRange(sc,i,pc.length + i);
       Arrays.sort(sc1);
       return Arrays.equals(sc1, pc);
    }

    public int subarraySum(int[] nums, int k) {

        int left = 0;
        int right = 1;
        int max = nums[0];
        int length = 0;
        if (max == k){
            length++;
        }
        while (right<nums.length){

            while (max < k && right < nums.length){
                max = max + nums[right];
                right++;
            }

            if (max == k){
                length++;
            }

            while ((max >= k || max < 0 ) && left < right - 1){
                max = max - nums[left];
                left++;
                if (max == k)
                    length++;
            }

        }


        return length;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";
        if (s.length() == t.length()){
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            Arrays.sort(sc);Arrays.sort(tc);
            if (sc.equals(tc))
                return s;
            else return "";
        }
        int left = 0;
        int min = 0;
        int num = 0;
        int centre = 0;
        int[] ct = new int[52];
        for (int i = 0; i < t.length(); i++){
            ct[t.charAt(i) - 'A'] = 1;
        }

        while (left < s.length() && ct[left] != 1)left++;
        ct[left]++;

        int right = left + 1;
        num = 1;
        int OK_LIFT = 0;
        int OK_RIGHT = 0;
        while (left < right){
            while (right < s.length()){
                if (ct[s.charAt(right) - 'A'] == 1){
                    ct[s.charAt(right) - 'A']++;
                    num++;
                    if (num != 3){
                        centre = right;
                    }

                }else if (ct[s.charAt(right) - 'A'] > 1 && s.charAt(centre) != s.charAt(right)){
                    if (right - centre >= centre - left){
                        left = centre;
                        centre = right;
                    }
                }
                if (num == 3)
                    break;
                right++;

            }

            for (int i = left + 1;i < right; i++){

                while (s.charAt(i) != s.charAt(left) && i < right)i++;
                if (i < right)left = i;

            }
            ct[s.charAt(left) - 'A']--;
            left = centre;
            num--;
            right++;
            OK_LIFT = left;
            OK_RIGHT = right;
        }

        System.out.println(OK_LIFT);
        System.out.println(OK_RIGHT);
        return s.substring(OK_LIFT,OK_RIGHT);

    }

    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;

        int[] c = new int[26];
        c['I'-'A'] = 1;
        c['V'-'A'] = 5;
        c['X'-'A'] = 10;
        c['L'-'A'] = 50;
        c['C'-'A'] = 100;
        c['D'-'A'] = 500;
        c['M'-'A'] = 1000;
        int sum = c[s.charAt(s.length() - 1) - 'A'];
        for (int i = s.length() - 1; i >= 1; i--){

            if (c[s.charAt(i - 1) - 'A'] >= c[s.charAt(i) - 'A']){
                System.out.println(s.charAt(i - 1)+"==="+s.charAt(i));
                sum = sum + c[s.charAt(i - 1) - 'A'];
            }else {
                sum = sum - c[s.charAt(i - 1) - 'A'];
            }
        }
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int index = 1;
        int right = 0;

        for (int i = 0; i < strs[0].length(); i++){
            try {
                while (index < strs.length && strs[index].charAt(i) == strs[index - 1].charAt(i))index++;
                if (index != strs.length) break;
                else right++;
                index = 1;
            }catch (Exception e){
                return strs[0].substring(0,right);
            }
        }

        return strs[0].substring(0,right);
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1)
            return s;

        int max = 0;
        String maxS = "";
        for (int i = 0; i < len; i++){
            if (max >= len-i)
                break;
            for (int j = i; j < s.length(); j++){
                String ss = s.substring(i,j + 1);
                int maxs = longestPalindrome_test(ss);
                if (max < maxs){
                    max = maxs;
                    maxS = ss;
                }

            }
        }

        return maxS;
    }

    public int longestPalindrome_test(String s){

        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right))return 0;
            left++;
            right--;
        }
        return s.length();
    }

    public boolean isValid(String s) {
        if (s.length() <= 1)
            return false;
        char[] ar = new char[128];
        ar['{'] = 0;
        ar['['] = 0;
        ar['('] = 0;
        ar['}'] = '{';
        ar[']'] = '[';
        ar[')'] = '(';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            if (ar[sc] == 0){
                stack.push(sc);
            }else {
                if ( !stack.isEmpty() && stack.peek() == ar[sc]){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    // 3        4        5
    // 4(2+1+1) 6(3+2+1) 8(4+3+1)
    //
    public String convert(String s, int numRows) {

        String reS = "";
        if (numRows == 1)
            return s;

        for (int i = 0; i < numRows; i++){
            int key = 1;
            if ( i == 0 || i == numRows - 1){

                for (int j = i; j < s.length(); j = j + (2 * numRows) - 2){
                    reS = reS + s.charAt(j);
                }
            }else {
                for (int j = i; j < s.length(); ){
                    reS = reS + s.charAt(j);

                    if (key == 1){
                        j = j + (2 * numRows) - 2 * (i+1);
                        key = 2;
                    }else {
                        j = j + 2 * i;
                        key = 1;
                    }
                }
            }
        }
        return reS;
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++){

            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left){
                list.add(intervals[i]);
            }else {
                list.get(list.size() - 1)[1] = Math.max( list.get(list.size() - 1)[1],right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();
    public void setZeroes(int[][] matrix){

        for (int i = 0; i < matrix.length; i++){
            if (xSet.contains(i))continue;
            for (int j = 0; j < matrix[0].length; j++){
                if (ySet.contains(j))continue;
                if (matrix[i][j] == 0){
                    setZeroesTestX(matrix,i,j);
                    setZeroesTestY(matrix,i,j);
                    break;
                }

            }
        }

    }

    public void setZeroesTestX(int[][] matrix, int x, int y) {
        xSet.add(x);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] == 0 && i != x){
                if (xSet.contains(i))continue;
                xSet.add(i);
                setZeroesTestY(matrix, i, y);
            }
            matrix[i][y] = 0;
        }

    }
    public void setZeroesTestY(int[][] matrix, int x, int y) {
        ySet.add(y);
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[x][i] == 0 && i != y){
                if (ySet.contains(i))continue;
                ySet.add(i);
                setZeroesTestX(matrix, x, i);
            }
            matrix[x][i] = 0;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (true){

            for (int i = left; i <= right; i++)list.add(matrix[top][i]);
            if (++top > bottom)break;
            for (int i = top; i <= bottom; i++)list.add(matrix[i][right]);
            if (--right < left)break;
            for (int i = right; i >= left; i--)list.add(matrix[bottom][i]);
            if (--bottom < top)break;
            for (int i = bottom; i >= top; i--)list.add(matrix[i][left]);
            if (++left > right)break;

        }

        return list;
    }

    public void rotate(int[][] matrix) {

        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        for (int i = 0; i < bottom; i++){

            for (int j = 0; j < right - i; j++){
                int num = matrix[i][j];
                matrix[i][j] = matrix[bottom - j][right - i];
                matrix[bottom - j][right - i] = num;
            }
        }
        for (int i = 0; i < matrix.length/2; i++){
            int[] nums = matrix[i];
            matrix[i] = matrix[bottom - i];
            matrix[bottom - i] = nums;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int i;
        while (true){

            for ( i = left; i <= right && matrix[top][i] < target; i++);
            if (i > right)i--;
            if (matrix[top][i] == target)return true;
            if ((right = i - 1) < left)break;
            for ( i = top; i <= bottom && matrix[i][right] < target; i++);
            if (i > bottom)i--;
            if (matrix[right][i] == target)return true;
            if ((bottom = i) < top )break;
            bottom--;
            for ( i = right; i >= left && matrix[bottom][i] > target; i--);
            if (i < left)i++;
            if (matrix[bottom][i] == target)return true;
            if ((left = i) > right)break;
            left--;
            for ( i = bottom; i >= top && matrix[i][left] > target; i--);
            if (i < top)i++;
            if (matrix[left][i] == target)return true;
            if ((top = i) > bottom)break;
            top--;

        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> xSet = new HashSet<>();
        Set<Character> ySet = new HashSet<>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (xSet.contains(board[i][j]) || ySet.contains(board[j][i]))return false;
                if (board[i][j] != '.')xSet.add(board[i][j]);
                if (board[j][i] != '.')ySet.add(board[j][i]);
            }
            xSet.clear();
            ySet.clear();
        }

        for(int i = 0; i < 9; i = i + 3){
            for (int j = 0; j < 9; j = j + 3){
                for (int n = i; n < i + 3; n++){
                    for (int m = j; m < j + 3; m++){
                        if (xSet.contains(board[n][m]))return false;
                        if (board[n][m] != '.')xSet.add(board[n][m]);
                    }
                }
                xSet.clear();

            }
        }

        return true;

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode p = headA;
        while (p != null){
            map.put(p,p.val);
            p = p.next;
        }
        p = headB;
        while (p != null){
            if (map.containsKey(p))return p;
            p = p.next;
        }
        return null;
    }

    public ListNode reverseList(ListNode head) {

        ListNode HEAD = null;
        ListNode P = head,p;
        while (P != null){
            p = P.next;
            P.next = HEAD;
            HEAD = P;
            P = p;
        }
        return HEAD;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = new ListNode(slow.val);
        ListNode reHead = fast;
        slow = slow.next;
        while (slow != null){
            ListNode reSlow = new ListNode(slow.val);
            fast.next = reSlow;
            fast = reSlow;
            slow = slow.next;
        }
        reHead = reverseList(reHead);
        ListNode P = head;
        while (reHead != null){
            if (reHead.val != P.val)return false;
            P = P.next;
            reHead = reHead.next;
        }
        return true;

    }

    public ListNode detectCycle(ListNode head) {

        ListNode p = head;

        Set<ListNode> set = new HashSet<>();
        while (p != null){
            if (set.contains(p))return p;
            set.add(p);
            p = p.next;
        }

        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode listNode = new ListNode();
        ListNode p = listNode;
        int num = 0;
        int sum = 0;
        while (p1 != null && p2 != null){
            sum = p1.val + p2.val + num;
            p.val = sum % 10  ;
            num = sum / 10;
            if (p1.next != null && p2.next != null){
                p.next = new ListNode();
                p = p.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null){
            sum = p1.val + num;
            p.next = new ListNode(sum % 10);
            num = sum / 10;
            p1 = p1.next;
            p = p.next;
        }

        while (p2 != null){
            sum = p2.val + num;
            p.next = new ListNode(sum % 10);
            num = sum / 10;
            p2 = p2.next;
            p = p.next;
        }

        if (num != 0){
            p.next = new ListNode(num);
        }

        ListNode.printList(listNode);
        return listNode;
    }

}

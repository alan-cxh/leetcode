package com.alan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Main {







    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each words

        Map<String, Integer> map = new HashMap(); // map for words
        for (String w : words) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }

        for (int i = 0; i < s.length() - len * words.length; i ++) {
            Map<String, Integer> copy = new HashMap(map);
            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j * len, i + j* len + len);
                if (copy.containsKey(str)){
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1 );
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else break; // not in words
            }
        }
        return res;
    }



    public boolean wordBreak(String s, Set<String> dict) {
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j]&&dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }


    /*--------------------------31---------------------------*/
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 1;
        for (; i > 0; i --) {
            if (nums[i] > nums[i-1]) break; // find first number which is smaller than it's after number
        }

        if ( i != 0) {
            swap(nums, i - 1);
        }
        
        reverse(nums, i);
        
    }

    private void reverse(int[] a, int i) {
        int first = i, last = a.length - 1;
        while (first < last) {
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }

    private void swap(int[] nums, int i) {
        int j = nums.length - 1;
        for (; j > i; j --){
            if (nums[j] > nums[i]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                break;
            }
        }
    }

    /*-------------------------32------------------------------*/
    // )()())
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, left = -1;
        for (int j = 0; j < s.length(); j ++) {
            if (s.charAt(j) == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else
                        max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }

    //TODO*-------------------------33------------------------------*/
    public int search(int[] nums, int target) {

        return 0;
    }

    //TODO*-------------------------34------------------------------*/
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (left + right) / 2 ;
            if (nums[mid] == target) {
                if (nums[left] == target && nums[right] == target)
                    return new int[]{left, right};
                else if (nums[left] != target)
                    left ++;
                else right --;
            } else if (nums[mid] < target)
                left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }

//TODO*-------------------------35------------------------------*/
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    //TODO*-------------------------36------------------------------*/

    /**
     * 判断是否满足条件的矩阵
     * @param board
     * @return
     *
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            HashSet<Character> rows = new HashSet();
            HashSet<Character> columns = new HashSet();
            HashSet<Character> cube = new HashSet();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                if (board[rowIndex +j/3][colIndex + j%3] != '.' && !cube.add(board[rowIndex + j/3][colIndex + j%3]))
                    return false;

            }
        }
        return true;
    }

    static int count = 0;

    //TODO*-------------------------37------------------------------*/

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c ++) {//trial. Try 1 through 9
                        System.out.println(count++);
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; // check row
            if (board[row][i] != '.' && board[row][i] == c) return false; // check column
            int rowIndex = 3*(row/3);
            int colIndex = 3*(col/3);
            if (board[rowIndex +i/3][colIndex + i%3] != '.' && board[rowIndex +i/3][colIndex + i%3] == c)
                return false;
        }
        return true;
    }

    //TODO*-===------------------------38------------------------------*/
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <s.length() ; j++) {

            }
        }
        return null;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.'  ,'.','7','.'  ,'.','.','.'},
                {'6','.','.'  ,'1','9','5'  ,'.','.','.'},
                {'.','9','8'  ,'.','.','.'  ,'.','6','.'},

                {'8','.','.'  ,'.','6','.'  ,'.','.','3'},
                {'4','.','.'  ,'8','.','3'  ,'.','.','1'},
                {'7','.','.'  ,'.','2','.'  ,'.','.','6'},

                {'.','6','.'  ,'.','.','.'  ,'2','8','.'},
                {'.','.','.'  ,'4','1','9'  ,'.','.','5'},
                {'.','.','.'  ,'.','8','.'  ,'.','7','9'},

        };
        Main app = new Main();
       app.solveSudoku(board);
        System.out.println();

    }
}

package zcc.初级算法.数组._10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc  2022/4/27 21:01
 */
public class Solution_10 {

    public static void main(String[] args) {
        char[][] chars = {
                {'8', '3', '.', '.', '3', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution_10 solution_10 = new Solution_10();
        System.out.println(solution_10.isValidSudoku(chars));

        char[][] chars1 ={
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(solution_10.isValidSudoku(chars1));
        System.out.println(solution_10.isValidSudoku1(chars));
        System.out.println(solution_10.isValidSudoku2(chars));
    }

    /**
     * 硬编码解决，嵌套循环 太low了、、
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Map<Character, Boolean> map0 = new HashMap<>();
            Map<Character, Boolean> map1 = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                //比较每一行
                if (board[i][j] != '.') {
                    if (map0.containsKey(board[i][j])) {
                        return false;
                    }
                    map0.put(board[i][j], true);
                }
                //比较每一列
                if (board[j][i] != '.') {
                    if (map1.containsKey(board[j][i])) {
                        return false;
                    }
                    map1.put(board[j][i], true);
                }
            }
        }
        //比较每一个小方格的值,每一个循环是比较三个横向的小方格
        for (int fromX = 0, toX = 2; fromX <= 6 && toX <= 8; fromX += 3, toX += 3) {
            //0,0--2,2;3,0--5,2;6,0--8,2
            Map<Character, Boolean> map = new HashMap<>();
            for (int i = fromX; i <= toX; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[i][j] != '.') {
                        if (map.containsKey(board[i][j])) {
                            return false;
                        }
                        map.put(board[i][j], true);
                    }
                }
            }
            //0,3--2,5;3,3--5,5;6,3--8,5
            Map<Character, Boolean> map1 = new HashMap<>();
            for (int i = fromX; i <= toX; i++) {
                for (int j = 3; j <= 5; j++) {
                    if (board[i][j] != '.') {
                        if (map1.containsKey(board[i][j])) {
                            return false;
                        }
                        map1.put(board[i][j], true);
                    }
                }
            }
            //0,6--2,8;3,6--5,8;6,6--8,8
            Map<Character, Boolean> map2 = new HashMap<>();
            for (int i = fromX; i <= toX; i++) {
                for (int j = 6; j <= 8; j++) {
                    if (board[i][j] != '.') {
                        if (map2.containsKey(board[i][j])) {
                            return false;
                        }
                        map2.put(board[i][j], true);
                    }
                }
            }

        }
        return true;
    }

    /**
     * 直接判断法
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board){
        int length = board.length;
        //二维数组row表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字4（3是第4位）
        int row[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i)
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //num用来做数组下标， 减1是为了不让下标越界
                int num = board[i][j] - '0' - 1;
                //这里是这个重点，如何把单元格三三切分成九个单元格，非常巧妙。 这里是横向切分，试试纵向切分？
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (row[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0){
                    return false;
                }
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                row[i][num] = column[j][num] = cell[k][num] = 1;
            }
        return true;
    }

    /**
     * 使用位运算,位运算非常巧妙
     * 因为在Java中，一个int有32位，那我们可以使用其中的9位来表示每一行中出现的数字
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board){
        int[] row = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int binary;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                //如果还没有填数字，直接跳过
                if (value == '.')
                    continue;
                binary = 1 << (value - '0');
                int k = (i / 3) * 3 + j / 3;
                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((row[i] & binary) > 0 || (column[j] & binary) > 0 || (cell[k] & binary) > 0){
                    return false;
                }
                row[i] |= binary;
                column[j] |= binary;
                cell[k] |= binary;
            }
        }
        return true;
    }
}

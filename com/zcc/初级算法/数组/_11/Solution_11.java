package zcc.初级算法.数组._11;

/**
 * @author zcc  2022/4/30 22:57
 * 旋转图像
 */
public class Solution_11 {

    public static void main(String[] args) {
        Solution_11 solution_11 = new Solution_11();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        solution_11.rotate(matrix);
    }

    /**
     * 先上下翻转，再沿对角线折叠
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        //上下翻转
        for (int i = 0; i < length/2; i++) {
            int[] temp =matrix[i];
            matrix[i]=matrix[length-i-1];
            matrix[length-i-1]=temp;
        }
        //对角线折叠
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                //使用异或交换两个值，是最保险的方式，可以防止越界
                int a = matrix[i][j];
                int b = matrix[j][i];
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
                matrix[i][j]=a;
                matrix[j][i]=b;
            }
        }
    }
}

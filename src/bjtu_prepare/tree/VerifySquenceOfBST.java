package bjtu_prepare.tree;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是【某二叉搜索树】的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] seq = {5, 10, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySquenceOfBST(seq));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int p = 0;
        int lenth = sequence.length;
        System.out.println("length:" + lenth);
        for (int i = 0; i < lenth - 1; i++) {
            if (sequence[i] < sequence[lenth - 1]) {
                p++;
                System.out.println(p);
            }
        }
        if (p == 0) {
            verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, lenth - 1));
        } else {
            for (int i = p; i < sequence.length - 1; i++) {
                if (sequence[i] < sequence[lenth - 1]) {
                    return false;
                }
            }
        }
        System.out.println("===");
        verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, p));
        System.out.println("---");
        verifySquenceOfBST(Arrays.copyOfRange(sequence, p, lenth - 1));
        return true;
    }

}

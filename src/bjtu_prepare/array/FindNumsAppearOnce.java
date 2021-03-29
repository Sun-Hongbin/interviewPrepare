package bjtu_prepare.array;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字
 */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array, int[] num1, int[] num2) {

    }

    public static void main(String[] args) throws UnsupportedEncodingException{

        String c1 = "sun hongin";
        byte[] c = c1.getBytes(StandardCharsets.UTF_8);
        String srt2=new String(c, StandardCharsets.UTF_8);
        System.out.println(srt2);
    }
}

package com.leetcode;

/**
 * @author binchu.liu
 * @date 16/08/2019 18:20
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;

public class KeDaXunFei1 {
    public static void main(String[] args) {
        String data = "爱讯飞789swr1wwen34ifly65tek";
        char[] nums = new char[data.toCharArray().length];
        int index = 0;
        for (char c : data.toCharArray()) {
            if (c <= '9' && c >= '0') {
                nums[index++] = c;
            }
        }
        if (index == 0) {
            System.out.println(-1);
        } else {
            nums = Arrays.copyOf(nums, index);
            Arrays.sort(nums);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < index; i++) {
                sb.append(nums[i]);
            }
            System.out.println(sb.toString());
        }

/*        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            //String data = in.nextLine();

        }*/
    }
}

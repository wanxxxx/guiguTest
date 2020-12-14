package String;

import java.io.UnsupportedEncodingException;

public class Test {
    //获取两个字符串中最大相同子串。比如：
    //str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    //提示：将短的那个串进行长度依次递减的子串与较长的串比较。


    public String LongestSameSubstr(String longstr, String shortstr) {
        //i代表子串的长度，j代表子串的开始位置
        String tmp;
        for (int i = shortstr.length(); i > 0; i--) {
            for (int j = 0; j < shortstr.length() - i + 1; j++) {
                tmp = shortstr.substring(j,j+i);
                if (longstr.contains(tmp)) {
                    return tmp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.LongestSameSubstr("abcwerthelloyuiodef","cvhellobnm"));
    }
}

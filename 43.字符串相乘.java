import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> addItemList = new ArrayList<>();
        char[] numCharList1 = num1.toCharArray();
        char[] numCharList2 = num2.toCharArray();
        for (int i = numCharList2.length - 1; i  >= 0; i--) {
            String addItem =  multiply(numCharList1, toNum(numCharList2[i])) ;

            for(int j = 0; j < numCharList2.length - 1 - i; j++) {
                addItem = addItem + "0";
            }
            addItemList.add(addItem);
        }
        return sum(addItemList);
    }

    private String sum(List<String> itemList) {
        int i = 0;
        String result = "";
        int next = 0;
        while(true) {
            boolean hasData = false;
            int data = next;
            for (String item : itemList) {
                int index = item.length() - 1 - i;
                if(index  >= 0) {
                    hasData = true;
                    data = data + toNum(item.charAt(index));
                }
            }
            if(!hasData) {
                break;
            }
            result = data % 10 + result;
            next = data / 10;
            i++;
        }
        if(next > 0) {
            result = next + result;
        }
        return result;

    }

    private int toNum(char cr) {
        return cr - '0';
    }

    private String multiply(char[] charList, int  mul) {
        String result = "";
        int next = 0;
        for (int i = charList.length - 1; i  >= 0; i--) {
            int item = toNum(charList[i]);
            int data = item * mul + next;
            result = data % 10 + result;
            next = data / 10;
        }
        if(next > 0) {
            result = next + result;
        }
        return result;
    }
}
// @lc code=end


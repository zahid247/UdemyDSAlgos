package JDSAlgoMasterclass.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString rw = new ReverseWordsInString();


        String s = "the sky is blue";
        String s1 = "ab-cd";
        int[] num1 = {1,2,3};
        int[] num2 = {2,5};

        System.out.println(rw.reverseWords(s));
        System.out.println(rw.reverseOnlyLetters(s1));
        System.out.println(rw.getCommon(num1, num2));

    }

    public int getCommon(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) {
            if (set1.contains(num)) return num;
        }

        return -1;
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int lastSpaceIndex = -1;
        int length = s.length();
        for (int strIndex = 0; strIndex < length; strIndex++) {
            if ((strIndex == length - 1) || s.charAt(strIndex) == ' ') {
                int reverseStringIndex = (strIndex == length - 1) ? strIndex : strIndex - 1;
                for (; reverseStringIndex > lastSpaceIndex; reverseStringIndex--) {
                    sb.append(s.charAt(reverseStringIndex));
                }
                if (strIndex != length - 1) sb.append(' ');
                lastSpaceIndex = strIndex;
            }
        }
        return new String(sb);
    }

    public String reverseOnlyLetters(String s) {

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            if (!Character.isLetter(chars[left])) left++;
            else if (!Character.isLetter(chars[right])) right--;
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;

            }
        }
        return new String(chars);
    }

}
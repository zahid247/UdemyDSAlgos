package JDSAlgoMasterclass.leetcode;

import java.util.*;

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString rw = new ReverseWordsInString();


//        String s = "the sky is blue";
//        String s1 = "ab-cd";
//        int[] num1 = {1,2,3};
//        int[] num2 = {2,5};
//
//        System.out.println(rw.reverseWords(s));
//        System.out.println(rw.reverseOnlyLetters(s1));
//        System.out.println(rw.getCommon(num1, num2));
//
//        System.out.println(Arrays.toString(rw.moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(rw.reversePrefix("abcdefg", 'd'));

    }

    public String reversePrefix(String word, char ch) {
        int length = word.length();
        if (length == 0 || length == 1) return word;
        int positionOfChar = 0;
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) == ch) {
                positionOfChar = i;
                break;
            }
        }
        if (positionOfChar == 0) return word;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i <= positionOfChar/2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(positionOfChar-i));
            sb.setCharAt(positionOfChar-i, temp);
        }
        return sb.toString();
    }

    public int[] moveZeroes(int[] nums) {
        int lastKnownZero = 0;
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0){
                int temp = nums[current];
                nums[current] = nums[lastKnownZero];
                nums[lastKnownZero] = temp;
                lastKnownZero++;
            }
        }
        return nums;
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
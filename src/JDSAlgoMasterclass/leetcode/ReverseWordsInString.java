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
//        System.out.println(rw.reversePrefix("abcdefg", 'd'));

//        System.out.println(rw.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
//        System.out.println(rw.maxVowels("abciiidef", 3));
//        System.out.println(rw.intersection(new int[][]{ {3,1,2,4,5} , {1,2,3,4} , {3,4,5,6} } ));

//        System.out.println(rw.subarraySum(new int[] {1,2,1,2,1}, 3));


        System.out.println(2174 & 1); /* the & symbol is the bitwise AND operator.
        It performs an AND operation on the binary representation of the two operands.
        In this case, num & 1 performs a bitwise AND between the integer num and 1. The bitwise
        AND operation compares each bit of the two numbers and returns a 1 only when both
        corresponding bits are 1; otherwise, it returns 0.*/
    }



    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int ans=0, curr=0;

        for (int num: nums) {
            System.out.println("num = " + num);

            curr += num;
            System.out.println("curr = " + curr);

            ans += counts.getOrDefault(curr - k, 0);
            System.out.println("counts.getOrDefault(curr - k, 0) = " + counts.getOrDefault(curr - k, 0));
            System.out.println("ans = " + ans);

            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
            System.out.println("counts = " + counts);

            System.out.println("-----NEXT ITERATION STARTS-----");
        }
        System.out.println("return ans = " + ans);
        return ans;
    }



    public boolean areOccurrencesEqual(String s) {

        Map<Character, Integer> counts = new HashMap<>();
        for (char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>(counts.values());
        return frequencies.size() == 1;
    }

    public List<Integer> intersection(int[][] nums) {

        Map<Integer, Integer> counts = new HashMap<>();

        for(int[] arr: nums)
            for(int j: arr)
                counts.put(j, counts.getOrDefault(j,0)+1);

        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int key: counts.keySet()){
            if(counts.get(key) == len) ans.add(key);
        }

        Collections.sort(ans);
        return ans;

    }

    public int maxVowels(String s, int k) {

        int length = s.length();
        int numVowels = 0;
        int left = 0;
        int right = 0;
        int res = 0;

        while (left < length - k+1){
            while (right < left + k){
                char c = s.charAt(right);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    numVowels++;
                }
                right++;
            }
            res = Math.max(res, numVowels);
            left++;
            right = left;
            numVowels = 0;
        }
        return res;
    }



    //This is not completed yet, still failing some test cases
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        if (length == 0 || length == 1) return ans;
        int left = 0, right = 1;
        int current = nums[left] + nums[right];
        while (left <= right && right < length) {
            if (current > target) {
                current-=nums[left];
                left++;
            }
            else if (current < target) {
                current+=nums[right];
                right++;
            }
            else{
                ans = Math.min(right - left + 1, ans);
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
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
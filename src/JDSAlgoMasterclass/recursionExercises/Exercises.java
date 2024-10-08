package JDSAlgoMasterclass.recursionExercises;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Exercises {

    public static void main(String[] args) {

        Exercises ex = new Exercises();

        System.out.println(Arrays.toString(ex.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));

    }


    public int[] getAverages(int[] nums, int k) {

        if (k == 0) return nums;

        int n = nums.length;
        int[] avgs = new int[n];

        for (int i=0; i<n; i++){

            if ((i < k) || ((n-i-1) < k)) avgs[i] = -1;
            else{
                int tempTotal = 0;
                for (int j=i-k; j<=i+k; j++){
                    tempTotal += nums[j];
                }
                avgs[i] = tempTotal / (2 * k + 1);
            }
        }
        return avgs;
    }


    public int containerWithMostWater(int[] heights){

        int left = 0;
        int right = heights.length-1;

        int maxVolume = Integer.MIN_VALUE;

        while (left<right){

            int result = (right - left) * Math.min(heights[left], heights[right]);

            maxVolume = Math.max(result, maxVolume);
            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return maxVolume;
    }

    public int[] twoSum(int[] arr, int target){

        int left = 0;
        int right = arr.length-1;

        while (left < right) {

            if (arr[left] + arr[right] == target) return new int[] {left, right};
            else if (arr[left] + arr[right] > target) right--;
            else left++;

        }
        System.out.println("Target value does not exist in the array.");
        return new int[] {-1,-1};

    }

    public String reverse(String str) {

        int size = str.length();
        StringBuilder reversed = new StringBuilder();
        for (int i = size-1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    //recursive version of the method above
    public String reverseRecursively(String str){

        if (str.isEmpty()) return str;

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    public boolean isPalindrome(String s){

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }

        return true;
    }

    public boolean isPalindromeRecursively(String s){

        if (s.length() == 0 || s.length() == 1) return true;

        if (s.charAt(0) == s.charAt(s.length()-1))
            return isPalindromeRecursively(s.substring(1, s.length()-1));

        return false;
    }

//    public boolean someRecursive(int[] arr, OddFunction odd) {
//        if (arr.length == 0 ) {
//            return false;
//        } else if (odd.run(arr[0]) == false) {
//            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
//        } else {
//            return true;
//        }
//    }

    char first(String str) {
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
//                return str.charAt(i);
//        }
//
//        return ' ';

        if(str.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        }else {
            return first(str.substring(1, str.length()));
        }
    }

    public String capitalizeWord(String str){

        if(str.isEmpty()) {
            return str;
        }
        char chr = str.charAt(str.length()-1);
        if(str.length()==1) {
            return Character.toString(Character.toUpperCase(chr));
        }
        if((str.substring(str.length()-2, str.length()-1).equals(" "))) {
            chr = Character.toUpperCase(chr);
        }
        return capitalizeWord(str.substring(0,str.length()-1))+ Character.toString(chr);

    }

}
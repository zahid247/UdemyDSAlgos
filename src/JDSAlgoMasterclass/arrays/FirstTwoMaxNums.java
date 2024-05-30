package JDSAlgoMasterclass.arrays;

import java.util.Arrays;

public class FirstTwoMaxNums {

    public static void main(String[] args) {

//        int[] myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
//        System.out.println(Arrays.toString(findTopTwoScores(myArray)));

//        int [] myArray = {1,2,3,4,6};
//        System.out.println(findMissingNumberInArray(myArray, 6));

//        System.out.println(Arrays.toString(removeDuplicatesArray(new int[]{1, 1, 2, 2, 3, 4, 5})));

//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));

//        String pairs = maxProduct(new int[]{10, 200, 30, 40, 500});
//        System.out.println(pairs);

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,2,3,1,9};
        System.out.println(permutation(arr1,arr2));


    }

    public static int[] findTopTwoScores(int[] array){

        int max = Integer.MIN_VALUE;
        int[] result = new int[2];

        for (int i=0; i < 2; i++){
            for (int j : array){

                if (isInArray(result, j)) break;
                else if (max < j) max = j;

            }
            result[i] = max;
            max = Integer.MIN_VALUE;
        }
        return result;
    }

    private static boolean isInArray(int[] arr, int value){
        for (int j =0; j<arr.length; j++){
            if (value == arr[j]){
                return true;
            }
        }
        return false;
    }

    static int findMissingNumberInArray(int[] arr, int value) {

        int sum = 0;
        for (int j : arr) sum +=j;

        int sumNeeded = (value*(value+1))/2;

        return sumNeeded - sum;
    }


    static int[] removeDuplicatesArray(int[] arr){

        int[] result = new int[arr.length];

        for (int i = 0, j=0; i < arr.length; i++) {

            if (!isInArray(result, arr[i])){
                result[j] = arr[i];
                j++;
            }

        }
        return result;
    }

    static int removeDuplicates(int[] nums){
        int duplCount = 0;

        for (int i = 0; i < nums.length-1; i++) {

            if (nums[i] == nums[i+1]) duplCount++;

        }

        return nums.length - duplCount;
    }

    public static int maxProfit(int[] prices) {
        // TODO

        int length = prices.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i<length; i++){
            int temp = prices[i];

            if (max < temp) max = temp;
            else if (min > temp) min = temp;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);

        return max-min;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0, j=1; i<nums.length-1; j++) {
            if ((nums[j] + nums[i]) == target) {
                result[0] = i;
                result[1] = j;
            }
            i++;
        }
        return result;
    }

    public static String maxProduct(int[] intArray) {

        int maxProduct = 0;
        String pairs = "";

        for (int i = 0; i < intArray.length; i++) {

            for (int j = i+1; j < intArray.length; j++) {

                if (intArray[i] * intArray[j] > maxProduct){
                    maxProduct = intArray[i] * intArray[j];
                    pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
                }

            }

        }
        return pairs;
    }

    public static boolean permutation(int[] array1, int[] array2){
        // TODO

        int length1 = array1.length;
        int length2 = array2.length;

        int count = 0;

        if (length1 != length2) return false;

        for (int i = 0; i < length1; i++) {
            int arr1 = array1[i];

            for (int j = 0; j < length2; j++) {
                int arr2 = array2[j];
                if (arr1 == arr2) {
                    count++;
                    break;
                }
            }
        }
        return count == length1;
    }

}



































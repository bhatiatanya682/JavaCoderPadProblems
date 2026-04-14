/**
 *
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class LongestUniformString {

    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){
        int longestStart = -1;
        int longestLength = 0;

        // your code goes here
        //edge case
        if(input == null || input.length() == 0){
            return new int[]{-1,0};
        }

        int length = input.length(); // abbbccda = 8
        int currentStart = 1;

        while(currentStart<length){
            int stringLength = 1;
            int start = currentStart-1;
            while(currentStart<length && input.charAt(currentStart) == input.charAt(currentStart-1)){
                stringLength++;//2-3
                currentStart++;//3-4
            }
            if(stringLength>longestLength){
                longestStart=start;
                longestLength=stringLength;
            }
            currentStart++;
        }
        return new int[]{ longestStart, longestLength };
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
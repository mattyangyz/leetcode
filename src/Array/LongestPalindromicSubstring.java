package Array;

public class LongestPalindromicSubstring {

    int low;
    int max;

    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        int j = 0;
        int k = 0;

        for(int i = 0; i < s.length() - 1; i++){
            longetPalHelper(s, i, i);
            longetPalHelper(s, i, i + 1);
        }
        return s.substring(low, low + max);
    }


    private void longetPalHelper(String s, int j, int k){

        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(k - j - 1> max){
            max = k - j - 1;
            low = j + 1;
        }
    }
}
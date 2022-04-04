package Array;

public class LongestPalindromicSubstring {

    int startIndex = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }

        for(int i = 0; i < s.length() - 1; i++){
            expandToBothSide(s, i, i);
            expandToBothSide(s, i, i + 1);

        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    private void expandToBothSide(String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                startIndex = left;
            }
            left--;
            right++;
        }
    }
}
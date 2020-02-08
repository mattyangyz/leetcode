package DP;

// DP
class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] array = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i == 0){
                    array[i][j] = j;
                }
                else if(j == 0){
                    array[i][j] = i;
                }
                else if(word1.charAt(i - 1) == (word2.charAt(j - 1))){
                    array[i][j] = array[i-1][j-1];
                } else if (word1.charAt(i - 1) != (word2.charAt(j - 1))) {
                    array[i][j] = 1 + Math.min(array[i-1][j], Math.min(array[i][j-1], array[i-1][j-1]));
                }
            }
        }
        return array[word1.length()][word2.length()];
    }
}
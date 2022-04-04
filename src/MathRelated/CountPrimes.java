package MathRelated;

// 这个是基于这个思路 -> https://www.youtube.com/watch?v=UGeCe5WQNVg&t=201s 第4：12分开始
public class CountPrimes {

    public static void main(String[] strs){
        countPrimes(10);
    }

    public static int countPrimes(int n){           // 这个写法是自己想初来的，把图画出来就知道结果了

        if(n < 2){
            return 0;
        }

        boolean[] array = new boolean[n + 1];
        System.out.println(array.length - 1);
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = true;
        }
        array[1] = false;
        array[2] = true;

        for(int i = 2; i * i< n; i++){

            if(array[i] == true){

                int j = i;
                int increment = j;
                while(j * increment <= n){
                    array[j * increment] = false;
                    increment++;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < array.length - 1; i++) {
            if(array[i]){
                count++;
            }
        }
        return count;
    }
}

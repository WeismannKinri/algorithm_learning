package codility.PrefixSums;

public class CountDiv {
    public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int n=0;
        if(A % K == 0) {
            n = A/K -1;
        }else {
            n = A/K;
        }
        return B/K - n ;

    }

    public static void main(String[] args) {
        System.out.println(solution(10,10,20));
    }
}
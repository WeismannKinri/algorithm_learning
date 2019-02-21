package codility.Arrays;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] array = new int[]{  9,5,1,9,3,1,3 };
        System.out.println(solution(array));

    }
    public static int solution(int[] A) {
        // write your code in Java SE 8

        int length = A.length;
        int number = 0;
        for(int i=0; i<length; i++) {
            number ^= A[i];
        }
        return number;
    }
}

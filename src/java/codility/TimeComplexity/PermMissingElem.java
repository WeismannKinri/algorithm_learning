package codility.TimeComplexity;

public class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        int max = A.length;
        if(max==0) {
            return 1;
        }
        for(int i=0;i<A.length;i++) {
            res^=(i+1);
            if(A[i]<=max) {
                res^=A[i];
            }
        }
        return res==0?max+1:res;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        long N = A.length + 1;
        long total = N * (N + 1) / 2;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }



}

package codility.PrefixSums;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int smallestIndex=0;
        double tempValue=(A[0]+A[1])/2.0;
        for(int i=0;i<A.length;i++){
            if(i<(A.length-1) && tempValue>(A[i]+A[i+1])/2.0){
                tempValue=(A[i]+A[i+1])/2.0;
                smallestIndex=i;
            }
            if(i<(A.length-2) && tempValue>(A[i]+A[i+1]+A[i+2])/3.0){
                tempValue=(A[i]+A[i+1]+A[i+2])/3.0;
                smallestIndex=i;
            }
        }
        return smallestIndex;
    }
}
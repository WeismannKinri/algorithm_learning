package codility.CountingElements;

public class MissingInteger {
    public int solution(int[] A){
        boolean[] booleans = new boolean[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i] > 0 && A[i] <= A.length){
                booleans[(A[i]-1)]=true;
            }
        }

        for(int j=0;j<A.length;j++){
            if(booleans[j]==false)
                return (j+1);
        }
        return (A.length+1);
    }
}

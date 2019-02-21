package codility.Maximumsliceproblem;

public class MaxSliceSum {
    public static int solution(int[] A){
        int size = A.length;
        int value = A[0];
        int last = value;
        for(int i=1;i<size;i++){
            last=Math.max(A[i],A[i]+last);
            if(last>value){
                value=last;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int [] a=  new int[]{1,2,3,-10,3};
        System.out.println(solution(a));
    }

}
package codility.PrefixSums;

public class PassingCars {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int cnt = 0;
        int cntCarsTravelingEast = 0;

        int i;
        for (i = 0; i < A.length; i++){
            if (A[i] == 0){
                cntCarsTravelingEast++;
            }
            else {
                cnt += cntCarsTravelingEast;
                if (cnt > 1000000000){
                    return -1;
                }
            }
        }
        return cnt;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int zCount = 0;  // how many going east
        int passing = 0; // total passing pairs

        for(int i : A){
            if(i == 1){
                passing += zCount;
            }
            else zCount++;
        }
        if(passing > 1e9 || passing < 0) return -1;
        else return passing;
    }

}

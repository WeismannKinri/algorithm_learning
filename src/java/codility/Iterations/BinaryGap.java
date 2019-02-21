package codility.Iterations;


/***
 * binary gap Algorithm
 */

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGap(1111));
    }
    static public int solution(int N) {
        // write your code in Java SE 8
        int NN = N;
        int gap = 0;
        int temp = 0;

        while (NN%2 == 0 && NN > 0)
        {
            NN /= 2;
        }

        while (NN > 0)
        {
            if (NN%2 == 0)
            {
                temp++;
            }
            else if (temp > gap)
            {
                gap = temp;
                temp = 0;
            }
            else
            {
                temp = 0;
            }

            NN /= 2;
        }

        return gap;
    }

    public static int binaryGap(int N) {
        int maxLen = 0;
        boolean bRightOne = false;
        int curLen = 0;
        while(N>0)
        {
            int curDigit = N%2;
            N /= 2;
            if(curDigit == 1)
            {
                if(!bRightOne)
                    bRightOne = true;
                else
                    maxLen = Math.max(maxLen, curLen);
                curLen = 0;
            }
            else curLen++;

        }
        //...return result
        return maxLen;
    }
}


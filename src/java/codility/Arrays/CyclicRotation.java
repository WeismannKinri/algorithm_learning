package codility.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {

    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int [] target = new int[A.length];
        for(int i=0;i<A.length;i++){
            target[(i+K)%A.length]=A[i];
        }
        return target;
    }

    public int[] solution2(int[] nums, int k) {
        k = (nums.length + (k % nums.length)) % nums.length; // 保证k为正

        int tmp;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = 0, j = k - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = k, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}

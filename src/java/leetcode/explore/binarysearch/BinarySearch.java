package leetcode.explore.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle=0;
        while(left<=right) {
            if(nums[left]==target) {
                return left;
            }
            if(nums[right]==target) {
                return right;
            }
            middle=(left+right)/2;
            if(nums[middle]==target) {
                return middle;
            }else if(nums[middle]>target) {
                left++;
                right=middle;
            }else if(nums[middle]<target) {
                left=middle;
                right--;
            }
        }
        return -1;
    }
}

package leetcode.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String target = String.valueOf(x);
        return helper(target,0,target.length()-1);
    }

    public boolean helper(String target,int start,int end){
        if(start>=end){
            return true;
        }
        else if(target.charAt(start)==target.charAt(end)&&start<end){
            return helper(target,start+1,end-1);
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(1001));
    }
}

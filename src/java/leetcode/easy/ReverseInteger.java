package leetcode.easy;

public class ReverseInteger {
    public int popAndPushDigitsCheckBeforeOverflow(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse(int x) {
        char[] targets;
        if(x<0){
            targets = (x+"").toCharArray();
        }else {
            targets =("+"+x+"").toCharArray();
        }

        for(int i=1;i<=(targets.length/2);i++){
            int tmp = targets[i];
            targets[i]=targets[targets.length-i];
            targets[targets.length-i]= (char) tmp;
        }

        String result = new String(targets);
        if(x<0){

            return Integer.parseInt("-"+result.substring(1));
        }else {
            return Integer.parseInt(result.substring(1));
        }
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }




}

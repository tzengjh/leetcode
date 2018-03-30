import java.lang.Integer;

public class Solution{
    public static int findNthDigit(int n){
        int digit = 1;//digit level, we start at one digit.
        long counts = 9;//the number counts of current digit level,we start at one digit,there are 9 numbers(1-9)which is at one digit.
        /**
         * number [1-9] (there are 9 numbers)is of one digit,number[10-99](there are 90 numbers) is
         * of two digits,number[100-999](there are 900 numbers) is of three digits,so first we should
         * find what level(i mean which digits(one digit,two digit or so on)  by level) the nth digit locate,
         * once we find the digit level, we achieve half the process,
         */
        /**
         *if n - digit * counts > 0,it means the nth digit is not at the current digit level,we should
         * increase digit level to pass more number
         */

        while (n - digit * counts > 0) {
            //every time we pass the number at current digit level
            n -= digit * counts;

            digit++;
            //counts are grow as follows,9,90,900,9000.....since the counts maybe overflow so i use long type
            counts *= 10;
        }
        //after loop,the n means nth digits from the current baseNumber

        //the base number is 1,10,100,1000,10000 and so on.
        int baseNumber = (int)Math.pow(10, digit - 1);
        //find the number where nth digit locate
        int number  = (n -1) / digit + baseNumber;
        System.out.println("findNthDigit num:" + number);
        //find the digit where nth digit locate at the number above
        int mod = (n - 1 ) % digit;
        return String.valueOf(number).charAt(mod) - '0';
    }

    public static int findNthDigit2(int n) {
        if(n <= 0) return -1;
        int k = 0;
        int sum = 0;
        do{
            k++;
            sum += k*9*tens(k-1); // overflow when k == 9
        }while(sum < n);
        System.out.println("findNthDigit2 sum:" + sum);
        sum -= k*9*tens(k-1);
        int num = tens(k - 1) + (n - sum - 1) / k;
        System.out.println("findNthDigit2 num:" + num);
        int x = (n - sum - 1) % k;
        char c = Integer.toString(num).charAt(x);
        return c - '0';
    }

    public static int tens(int k){
        if(k < 0) throw new IllegalArgumentException();
        if(k == 0) return 1;
        return tens(k - 1) * 10;
    }

    public static void main(String[] args) {
        long m = 1;
        for(int i = 1; i < 20; i ++){
            System.out.println("findNthDigit:" + findNthDigit((int)m));
            System.out.println("findNthDigit2:" + findNthDigit2((int)m));
            m *= 10;
        }
    }
}
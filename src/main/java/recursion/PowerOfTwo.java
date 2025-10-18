package recursion;

public class PowerOfTwo {

    public static void main(String[] args) {
        int[] n = {16, 7, 8, 10, 1, 0, 2};
        for ( int x : n){
//            System.out.println("Is " + x + " power of 2? " + isPowerOfTwoRecursive(x));
            System.out.println("Is " + x + " power of 2? " + isPowerOfTwo(x));
        }
    }

    public static boolean isPowerOfTwo(int n){
        if(n<1) return false;
        while(n % 2 == 0){
            n = n / 2;
        }
        return n == 1;
    }

    public static boolean isPowerOfTwoRecursive(int n) {

        if (n == 1){
            return true;
        }

        if ( (n <= 0) || (n%2 != 0) ){
            return false;
        }

        return isPowerOfTwoRecursive(n/2);
    }
}

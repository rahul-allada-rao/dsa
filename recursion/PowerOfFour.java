package recursion;

public class PowerOfFour {

    public static void main(String[] args) {
        int[] n = {4,5,-1,0,16,64,128,256};
        for ( int x : n){
            System.out.println("Is " + x + " power of 4? " + isPowerOfFour(x));
        }

    }

    public static boolean isPowerOfFour(int n){

        if (n < 1){
            return false;
        }

        if (n == 1){
            return true;
        }

        if (n%4 != 0){
            return false;
        }

        return isPowerOfFour(n/4);
    }
}

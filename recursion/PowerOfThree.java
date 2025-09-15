package dsa.recursion;

public class PowerOfThree {
    public static void main(String[] args) {
        int[] n = {27, 0, -1, 81};
        for (int x : n){
            System.out.println("Is " + x + " power of 3? " + isPowerOfThree(x));
        }
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1){
            return true;
        }

        if (n < 1){
            return false;
        }

        if (n % 3 != 0){
            return false;
        }

        return isPowerOfThree(n/3);
    }
}

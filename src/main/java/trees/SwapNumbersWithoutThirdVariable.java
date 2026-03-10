package trees;


public class SwapNumbersWithoutThirdVariable {

    private static void swap(int first, int second) {
        System.out.println("first = " + first + ", second = " + second);
        second += first;
        first = second - first;
        second = second - first;
        System.out.println("first = " + first + ", second = " + second);
    }
}

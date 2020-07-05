package Throwable;

public class ThrowsException {
    public static void main(String[] args) throws RuntimeException {
        int[] arr = null;
        int i = arr[10];
        System.out.println(i);
    }
}

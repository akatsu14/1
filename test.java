public class test {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int value = arr[5]; // This will result in an ArrayIndexOutOfBoundsException
        System.out.println(value);
    }
}

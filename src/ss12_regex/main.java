package ss12_regex;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr ={1, 2,3,4,4};
        System.out.println(Arrays.stream(arr).filter(item -> item % 2 ==0).sum());
    }

}

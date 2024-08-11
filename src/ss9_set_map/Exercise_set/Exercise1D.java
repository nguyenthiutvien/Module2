package ss9_set_map.Exercise_set;

import java.util.TreeSet;

public class Exercise1D {
    public static void main(String[] args) {
        int[] arr = {5, 2,1,3,1,1,2};
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int min = set.first();
        int max = set.last();
        System.out.println("MIN: " + min);
        System.out.println("MAX: " + max);
    }

}

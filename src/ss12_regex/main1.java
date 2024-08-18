package ss12_regex;

import java.util.Arrays;
import java.util.List;

public class main1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40);
int sum = list.stream().reduce(0, Integer::sum);
int total = list.stream().max(Integer::compareTo).get();
    }

}

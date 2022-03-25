import java.util.*;
import java.util.stream.*;


public class Main {

    public static void main(String[] args) {
        int[] list = new int[] {1,21,55,4,8,23,2,5,35,21,35,21,22,54,51};
        log(listToString(list));
        int leftSignIndex = -1;
        for(int index = 0; index < list.length; index++) {
            int item = list[index];
            if((item & 1) == 1) {
                if(index -1 > leftSignIndex) {
                    for(int warpIndex = index; warpIndex > leftSignIndex + 1; warpIndex--) {
                        swap(list, warpIndex, warpIndex - 1);
                    }
                }
                leftSignIndex++;
            }
        }
        log(listToString(list));

    }

    private static String listToString(int[] list) {
        return Arrays.stream(list).mapToObj(i -> i + "").collect(Collectors.joining(","));
    }

    private static void swap(int[] list, int indexA, int indexB) {
        log("交换", indexA, indexB);
        int temp = list[indexA];
        list[indexA] = list[indexB];
        list[indexB] = temp;
    }

    private static void log(Object... args) {
        System.out.println(Arrays.stream(args).map(Object::toString).collect(Collectors.joining(",")));
    }
}

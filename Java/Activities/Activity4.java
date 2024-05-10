package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] numbers = {4, 7, 9, 3, 1, 0, 5, 8, 2, 6};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j <= numbers.length - 1; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
            System.out.print(Arrays.toString(numbers));
    }
}

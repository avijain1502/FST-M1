package activities;

import java.lang.reflect.Array;

public class Activity2 {
    public  static  void main (String args[]){
        int[] numbers =  {10, 77, 10, 54, -11, 10};
        int sum=0;
        for (int number: numbers) {
            if (number==10)
            {
              sum = sum+number;
            }
        }
        System.out.println(sum);
    }
}

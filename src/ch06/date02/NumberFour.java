package ch06.date02;

import java.util.Scanner;

public class NumberFour {

    static int sum(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    static int average(int[] numbers) {
        int average = sum(numbers) / numbers.length;

        return average;
    }

    static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        return numbers;
    }

    static int max(int[] numbers) {
        int sort[] = bubbleSort(numbers);
        int max = sort[numbers.length - 1];

        return max;
    }

    static int min(int[] numbers) {
        int sort[] = bubbleSort(numbers);
        int min = sort[0];

        return min;
    }

    public static void main(String[] args) {

        int[] numbers = new int[10];

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 10개를 입력하세요 : ");

        for(int count = 0; count < 10; count++) {
            numbers[count] = sc.nextInt();
        }

        System.out.println("점수 합계 : " + sum(numbers));
        System.out.println("평균 점수 : " + average(numbers));
        System.out.println("최고 점수 : " + max(numbers));
        System.out.println("최저 점수 : " + min(numbers));
    }
}

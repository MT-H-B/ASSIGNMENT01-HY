package ch06.sec09;

import java.util.Scanner;

public class NumberThree {
    public static void main(String[] args) {
        int answer = (int)(Math.random() * 100) + 1;
        Scanner scan = new Scanner(System.in);
        int num;
        int cnt = 0;

        while(true){
        System.out.print("1~100 사이의 수 입력 : ");
        num = scan.nextInt();

        if (num == answer) {
            cnt++;
            System.out.println("정답입니다. 총 횟수 : " + cnt + "회");
            break;
        }
        else if (num > answer) {
            System.out.println("더 작습니다.");
            cnt++;
        }
        else if (num < answer) {
            System.out.println("더 큽니다.");
            cnt++;
        }
        }
    }
}

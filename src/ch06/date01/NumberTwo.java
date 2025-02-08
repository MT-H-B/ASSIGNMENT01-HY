package ch06.sec09;

public class NumberTwo {
    public static void main(String[] args) {
        int a,b,cnt;
        for (int i = 1; i <= 100; i++) {
            a = i / 10; //10의 자릿수
            b = i % 10; //1의 자릿수
            cnt = 0;

            //3,6,9 숫자 포함 시 CLAP 출력
            if ((a != 0 && a % 3 == 0) || (b != 0 && b % 3 == 0)) {
                System.out.print("CLAP\t");
            }
            else {
                System.out.print(a);
                System.out.print(b + "\t\t");
            }

            //한 줄에 10개의 숫자 출력
            if (i % 10 == 0)
                System.out.println();
        }
    }
}

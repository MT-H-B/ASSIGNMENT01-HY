package ch06.date03.numberSix;

public class BankTest {

    public static void main(String args[]) {
        System.out.println("========== 계좌 개설 ==========");
        Bank woori = new Bank("우리은행", 100000);
        Bank kb = new Bank("국민은행", 200000);

        System.out.println(woori.getName() + " : " + woori.getBalance());
        System.out.println(kb.getName() + " : " + kb.getBalance());

        System.out.println("========== 송금 =========");
        //우리은행에서 50000원을 출금하여 국민은행에 50000원을 입금하는 로직
        long amount = woori.withdrawal(50000);
        kb.deposit(amount);
        System.out.println(woori.getName() + " : " + woori.getBalance());
        System.out.println(kb.getName() + " : " + kb.getBalance());

        System.out.println("========== 출금 ==========");
        //우리은행에서 200000원을 출금하려하지만 잔액부족으로 출금이 안됨.
        long wooriAmount = woori.withdrawal(200000);
        System.out.println(woori.getName() + "에서 출금한 금액 : " + wooriAmount);
        System.out.println(woori.getName() + " : " + woori.getBalance());
    }
}

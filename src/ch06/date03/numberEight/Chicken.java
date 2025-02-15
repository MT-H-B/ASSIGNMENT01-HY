package ch06.date03.numberEight;

public class Chicken implements Eatable{

    private int number;

    @Override
    public void eat() {
        System.out.println("치킨을 먹습니다");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

package ch06.date03.numberEight;

public class Fish implements Eatable{

    private int number;

    @Override
    public void eat() {
        System.out.println("물고기를 먹습니다");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

package ch06.date03.numberEight;

public class Coffee implements Drinkable{

    public int capacity;

    @Override
    public void drink() {
        System.out.println("커피를 마십니다");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

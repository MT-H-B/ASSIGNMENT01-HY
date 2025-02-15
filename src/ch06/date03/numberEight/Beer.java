package ch06.date03.numberEight;

public class Beer implements Drinkable {

    private int capacity;

    @Override
    public void drink() {
        System.out.println("맥주를 마십니다");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

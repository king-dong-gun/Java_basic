package access.ex.exam02;

import java.io.PrintStream;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public ShoppingCart() {
    }

    public void addItem(Item item) {
        if (this.itemCount >= this.items.length) {
            System.out.println("장바구니가 가득 찼습니다.");
        } else {
            this.items[this.itemCount] = item;
            ++this.itemCount;
        }
    }

    public void displayItems() {
        System.out.println("===장바구니 정보===");

        for(int i = 0; i < this.itemCount; ++i) {
            Item item = this.items[i];
            PrintStream var10000 = System.out;
            String var10001 = item.getName();
            var10000.println("상품명: " + var10001 + ", 가격: " + item.getTotalPrice() + "원");
            System.out.println("총 가격: " + this.calculateTotalPrice() + "원");
        }

    }

    private int calculateTotalPrice() {
        int totalPrice = 0;

        for(int i = 0; i < this.itemCount; ++i) {
            Item item = this.items[i];
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }
}

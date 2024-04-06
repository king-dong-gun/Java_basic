package classStart.ex.exam02;

public class ProductOrderMain {
    public ProductOrderMain() {
    }

    public static void main(String[] args) {
        ProductOrder[] productOrder = new ProductOrder[3];
        int totalPrice = 0;
        ProductOrder order1 = new ProductOrder();
        order1.productName = "두부";
        order1.price = 2000;
        order1.quantity = 3;
        productOrder[0] = order1;
        ProductOrder order2 = new ProductOrder();
        order2.productName = "김치";
        order2.price = 3000;
        order2.quantity = 3;
        productOrder[1] = order2;
        ProductOrder order3 = new ProductOrder();
        order3.productName = "콜라";
        order3.price = 1500;
        order3.quantity = 2;
        productOrder[2] = order3;
        ProductOrder[] var6 = productOrder;
        int var7 = productOrder.length;

        for (int var8 = 0; var8 < var7; ++var8) {
            ProductOrder order = var6[var8];
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 갯수: " + order.quantity);
            totalPrice += order.price * order.quantity;
        }

        System.out.println("총 " + totalPrice + "원 입니다.");
    }
}

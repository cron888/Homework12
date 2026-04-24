import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket != null ? basket.clone() : null;
    }

    // Геттеры /
    public String getCustomer() { return customer; }
    public Product[] getBasket() { return basket != null ? basket.clone() : null; }

    @Override
    public String toString() {
        return "Заказ{клиент='" + customer + '\'' +
                ", корзина=" + Arrays.toString(basket) + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;

        if (!Objects.equals(customer, order.customer)) return false;

        Product[] thisBasket = this.basket;
        Product[] otherBasket = order.basket;

        if (thisBasket == null && otherBasket == null) return true;
        if (thisBasket == null || otherBasket == null) return false;
        if (thisBasket.length != otherBasket.length) return false;

        for (int i = 0; i < thisBasket.length; i++) {
            Product p1 = thisBasket[i];
            Product p2 = otherBasket[i];

            if (p1 == null && p2 == null) continue;
            if (p1 == null || p2 == null) return false;
            if (!p1.equals(p2)) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customer);
        if (basket != null) {
            for (Product p : basket) {
                result = 31 * result + (p != null ? p.hashCode() : 0);
            }
        }
        return result;
    }
}

import java.util.Arrays;
import java.util.Objects;

// Класс товара
class Product {
    private int id;
    private String name;
    private int price;
    private String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Товар[артикул=" + id +
                ", название=" + name +
                ", цена=" + price +
                ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id &&
               Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}

// Класс заказа
class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket != null ? basket.clone() : null;
    }

    // Геттеры
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

        // Сравниваем клиента
        if (!Objects.equals(customer, order.customer)) return false;

        // Сравниваем массив товаров
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

public class Main {
    public static void main(String[] args) {
        // Тестирование класса Product
        System.out.println("=== Тестирование класса Product ===");
        Product p1 = new Product(101, "Смартфон", 50000, "Электроника");
        Product p2 = new Product(101, "Смартфон Pro", 60000, "Электроника");
        Product p3 = new Product(102, "Смартфон", 50000, "Электроника");
        Product p4 = new Product(101, "Смартфон", 50000, "Бытовая техника");
        Product p5 = new Product(101, "Смартфон", 50000, "Электроника");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        System.out.println("\nСравнение товаров:");
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true (id и категория совпадают)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false (разные id)
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // false (разные категории)
        System.out.println("p1.equals(p5): " + p1.equals(p5)); // true

        // Тестирование класса Order
        System.out.println("\n=== Тестирование класса Order ===");
        Product[] basket1 = {p1, p2};
        Product[] basket2 = {p1, p2};
        Product[] basket3 = {p2, p1}; // другой порядок
        Product[] basket4 = {p1};     // другой состав

        Order o1 = new Order("Иван Петров", basket1);
        Order o2 = new Order("Иван Петров", basket2);
        Order o3 = new Order("Иван Петров", basket3);
        Order o4 = new Order("Иван Петров", basket4);
        Order o5 = new Order("Анна Смирнова", basket1);

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

        System.out.println("\nСравнение заказов:");
        System.out.println("o1.equals(o2): " + o1.equals(o2)); // true
        System.out.println("o1.equals(o3): " + o1.equals(o3)); // false (порядок разный)
        System.out.println("o1.equals(o4): " + o1.equals(o4)); // false (состав разный)
        System.out.println("o1.equals(o5): " + o1.equals(o5)); // false (клиент разный)
    }
}
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
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // false
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
        System.out.println("o1.equals(o3): " + o1.equals(o3)); // false
        System.out.println("o1.equals(o4): " + o1.equals(o4)); // false
        System.out.println("o1.equals(o5): " + o1.equals(o5)); // false
    }
}
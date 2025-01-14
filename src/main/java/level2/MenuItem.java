package level2;

public class MenuItem {
    private String foodName;
    private int price;
    private String menuInfo;
    private static long totalPrice;

    public MenuItem(String foodName, int price, String menuInfo) {
        this.foodName = foodName;
        this.price = price;
        this.menuInfo = menuInfo;
    }

    @Override
    public String toString() {
        return foodName + " : " + price +"원   |" + menuInfo;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public static void totalPrice(int price){
        totalPrice += price;
    }

    public static long getTotalPrice() {
        return totalPrice;
    }
}

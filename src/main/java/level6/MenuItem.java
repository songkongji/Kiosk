package level6;

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

    public static void totalPrice(long price){   //선택한 메뉴 가격 더하기
        totalPrice += price;
    }

    public static long getTotalPrice() {    //선택한 메뉴 총합 가격
        return totalPrice;
    }
}

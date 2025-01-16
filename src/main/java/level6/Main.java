package level6;

import level4.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<level4.MenuItem> menuList = new ArrayList<>();
        menuList.add(new level4.MenuItem("shackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new level4.MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new level4.MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new level4.MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<level4.MenuItem> menuList2 = new ArrayList<>();
        menuList2.add(new level4.MenuItem("콜라", 2000, "코카콜라"));
        menuList2.add(new level4.MenuItem("사이다", 2000, "스프라이트"));
        menuList2.add(new level4.MenuItem("제로콜라", 2000, "제로코카콜라"));
        menuList2.add(new MenuItem("제로사이다", 2000, "제로스프라이트"));

        List<Menu> categories = new ArrayList<>();
        categories.add(new Menu("Burger", menuList));
        categories.add(new Menu("Drink", menuList2));

        Kiosk kiosk = new Kiosk(categories);
        kiosk.start();
    }
}

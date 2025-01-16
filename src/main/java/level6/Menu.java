package level6;

import level4.MenuItem;

import java.util.List;

public class Menu {
    private List<level4.MenuItem> menuItems;
    private String category;

    public Menu(String category, List<level4.MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}

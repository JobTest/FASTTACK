package com.cts.fasttack.admin.web.data.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexandr Lypivets
 */
public class MenuItemRepository {

    private List<MenuItem> items = new ArrayList<>();

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}

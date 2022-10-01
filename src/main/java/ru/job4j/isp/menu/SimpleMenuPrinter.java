package ru.job4j.isp.menu;

import java.util.*;

public class SimpleMenuPrinter implements MenuPrinter {

    public static final String TAB = "----";

    @Override
    public void print(Menu menu) {
        Deque<Menu.MenuItemInfo> deque = new LinkedList<>();
        var i = menu.iterator();
        boolean isChild;
        while (i.hasNext()) {
            var menuItemInfo = i.next();
            var prefix = "";
            isChild = menuItemInfo.getChildren().size() == 0;
            if (!deque.isEmpty() && !deque.peekLast().getChildren().contains(menuItemInfo.getName())) {
                if (!isChild) {
                    deque.removeLast();
                } else {
                    deque.clear();
                }
            }
            if (!isChild) {
                deque.addLast(menuItemInfo);
            }
            if (deque.size() > 0) {
                var depth = isChild ? deque.size() : deque.size() - 1;
                prefix = new String(new char[depth]).replace("\0", TAB);
            }
            System.out.println(prefix + menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}

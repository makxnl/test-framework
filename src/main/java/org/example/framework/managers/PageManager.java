package org.example.framework.managers;

import org.example.framework.pages.FoodPage;

public class PageManager {

    private static PageManager pageManager;

    private FoodPage foodPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public FoodPage getFoodPage() {
        if (foodPage == null) {
            foodPage = new FoodPage();
        }
        return foodPage;
    }

    public static void quit(){
        pageManager = null;
    }
}

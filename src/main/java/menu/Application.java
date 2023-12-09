package menu;

import menu.controller.MenuRecommendationController;

public class Application {
    public static void main(String[] args) {
        MenuRecommendationController menuRecommendationController = new MenuRecommendationController();
        menuRecommendationController.startRecommendationProcess();
    }
}

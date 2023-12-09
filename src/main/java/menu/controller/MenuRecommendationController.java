package menu.controller;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.inputParser.CoachNameParser;
import menu.domain.inputParser.RestrictedMenuParser;
import menu.domain.recommender.CategoryRecommender;
import menu.domain.recommender.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuRecommendationController {
    private final MenuRecommender menuRecommender;
    private final CategoryRecommender categoryRecommender;
    private final List<Coach> coaches;

    public MenuRecommendationController() {
        this.coaches = new ArrayList<>();
        this.menuRecommender = new MenuRecommender();
        this.categoryRecommender = new CategoryRecommender();
    }

    public void startRecommendationProcess() {
        OutputView.startRecommendation();
        processCoachInput();
        List<Menu> weeklyCategories = categoryRecommender.recommendWeeklyCategories();
        recommendMenus(weeklyCategories);

        OutputView.printResults(coaches, weeklyCategories);
        OutputView.endRecommendation();
    }

    private void processCoachInput() {
        String coachNamesInput = InputView.inputCoachName();
        CoachNameParser nameParser = new CoachNameParser();
        List<String> coachNames = nameParser.parseNames(coachNamesInput);
        RestrictedMenuParser parser = new RestrictedMenuParser();

        for (String name : coachNames) {
            String restrictedMenus = InputView.inputMenuRestrictions(name);
            Set<String> restrictedMenuSet = parser.parseMenus(restrictedMenus);
            coaches.add(new Coach(name, restrictedMenuSet));
        }
    }


    private void recommendMenus(List<Menu> weeklyCategories) {
        for (Menu category : weeklyCategories) {
            for (Coach coach : coaches) {
                String recommendedMenu = menuRecommender.recommendMenu(coach, category);
                coach.addMenu(recommendedMenu);
            }
        }
    }
}
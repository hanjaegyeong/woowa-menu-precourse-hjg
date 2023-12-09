package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.constant.MenuCategory;

import java.util.List;

public class MenuRecommender {
    public void recommendMenu(Coach coach, MenuCategory category) {
        List<String> menus = category.getMenus();

        while(true){
            String shuffledMenu = Randoms.shuffle(menus).get(0);
            if(coach.canAddMenu(shuffledMenu)){
                coach.addMenu(shuffledMenu);
                return;
            }
        }
    }
}

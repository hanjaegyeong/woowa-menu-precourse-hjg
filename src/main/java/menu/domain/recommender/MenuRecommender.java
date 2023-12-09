package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Menu;

import java.util.List;

public class MenuRecommender {
    public void recommendMenu(Coach coach, Menu category) {
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

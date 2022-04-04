package com.example.tordertest.dto.menu;

import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.menu.MenuStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class MenuRes {
    private Long menuId;
    private String menuName;
    private int price;
    private String type;
    private String imageUrl;
    private MenuStatus menuStatus;


    @Builder
    public MenuRes(Long menuId,String menuName, int price, String type, String imageUrl, MenuStatus menuStatus) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.type = type;
        this.imageUrl = imageUrl;
        this.menuStatus = menuStatus;
    }

    public static MenuRes of(Menu menu) {
        return MenuRes.builder()
                .menuId(menu.getId())
                .menuName(menu.getMenuName())
                .price(menu.getPrice())
                .type(menu.getType())
                .imageUrl(menu.getImageUrl())
                .menuStatus(menu.getMenuStatus())
                .build();
    }

    public static List<MenuRes> list(List<Menu> menuList){
        List<MenuRes> menuResList = new ArrayList<>();

        for(Menu menu : menuList){
            menuResList.add(of(menu));
        }
        return menuResList;
    }


}

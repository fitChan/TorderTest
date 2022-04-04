package com.example.tordertest.dto.menu;

import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.menu.MenuStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class MenuDetailRes {
    private Long menuId;
    private String menuName;
    private int price;
    private String type;
    private String desc;
    private String imageUrl;
    private MenuStatus menuStatus;

    @Builder
    public MenuDetailRes(Long menuId, String menuName, int price, String type, String desc, String imageUrl, MenuStatus menuStatus) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.type = type;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.menuStatus = menuStatus;
    }

    public static MenuDetailRes of(Menu menu){
        return MenuDetailRes.builder()
                .menuId(menu.getId())
                .menuName(menu.getMenuName())
                .price(menu.getPrice())
                .type(menu.getType())
                .desc(menu.getDesc())
                .imageUrl(menu.getImageUrl())
                .menuStatus(menu.getMenuStatus())
                .build();
    }
}

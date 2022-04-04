package com.example.tordertest.service.menu;

import com.example.tordertest.dto.menu.MenuDetailRes;
import com.example.tordertest.dto.menu.MenuRes;
import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;


    //메뉴 전체 조회
    @Transactional
    public List<MenuRes> getAllmenu(){
        List<Menu> menuList = menuRepository.findAll();
        return MenuRes.list(menuList);
    }

    //메뉴 상세 조회
    @Transactional
    public MenuDetailRes getDetailMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                ()->new IllegalArgumentException("해당하는 메뉴가 존재하지 않습니다.")
        );
        return MenuDetailRes.of(menu);
    }

}

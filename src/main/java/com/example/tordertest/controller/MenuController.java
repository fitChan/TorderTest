package com.example.tordertest.controller;


import com.example.tordertest.dto.menu.MenuDetailRes;
import com.example.tordertest.dto.menu.MenuRes;
import com.example.tordertest.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    // 전체 메뉴 조회
    @GetMapping()
    public ResponseEntity<List<MenuRes>> getAllmenu(){
        return ResponseEntity.ok().body(menuService.getAllmenu());
    }

    // 상세 조회
    @GetMapping("/{menuId}")
    public ResponseEntity<MenuDetailRes> getDetailMenu(@PathVariable Long menuId){
        return ResponseEntity.ok().body(menuService.getDetailMenu(menuId));
    }



}

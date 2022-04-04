package com.example.tordertest.entity.menu;

import com.example.tordertest.entity.TimeStamped;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    private String menuName;

    private int price;

    private String type;

    private String desc;

    private String imageUrl;

    private MenuStatus menuStatus = MenuStatus.ON_SALE;



    /*TO DO
    *
    * 이미지 넣는거 해야함
    *
    * */
}

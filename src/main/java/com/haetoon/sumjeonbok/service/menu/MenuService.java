package com.haetoon.sumjeonbok.service.menu;

import com.haetoon.sumjeonbok.model.entity.MenuInfo;
import com.haetoon.sumjeonbok.repository.MenuInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuInfoRepository menuInfoRepository;
    public List<MenuInfo> getAllMenuInfo(){
        List<MenuInfo>menuInfoList = menuInfoRepository.findAll();
        return menuInfoList;
    }
}

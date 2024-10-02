package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Menu;
import com.haetoon.sumjeonbok.model.entity.MenuInfo;
import com.haetoon.sumjeonbok.model.entity.Size;
import com.haetoon.sumjeonbok.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuInfoRepository extends JpaRepository<MenuInfo,Long> {
    Optional<MenuInfo>findByMenuAndTypeAndSize(Menu menu, Type type , Size size);
}

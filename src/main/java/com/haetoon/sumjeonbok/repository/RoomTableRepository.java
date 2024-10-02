package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Room;
import com.haetoon.sumjeonbok.model.entity.RoomTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTableRepository extends JpaRepository<RoomTable,Long> {
    List<RoomTable> findByRoom(Room room);
}

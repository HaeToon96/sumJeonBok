package com.haetoon.sumjeonbok.repository;

import com.haetoon.sumjeonbok.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Room> findByName(String name);

}

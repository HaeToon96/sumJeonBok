package com.haetoon.sumjeonbok;

import com.haetoon.sumjeonbok.model.entity.Room;
import com.haetoon.sumjeonbok.model.entity.RoomTable;
import com.haetoon.sumjeonbok.model.entity.MyTable;
import com.haetoon.sumjeonbok.repository.RoomRepository;
import com.haetoon.sumjeonbok.repository.RoomTableRepository;
import com.haetoon.sumjeonbok.repository.TableRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SumJeonBokApplicationTests {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private RoomTableRepository roomTableRepository;
    @Order(1)
    @Test
    void insertRoom(){
        Room room1 = new Room();
        room1.setName("거실");
        roomRepository.save(room1);
        Room room2 = new Room();
        room2.setName(("앞방"));
        roomRepository.save(room2);
        Room room3 = new Room();
        room3.setName("옆방");
        roomRepository.save(room3);
    }
    @Order(2)
    @Test
    void insertTable(){
        for(int i=0; i<12; i++){
            MyTable table = new MyTable();
            table.setNumber(i+1);
            tableRepository.save(table);
        }
    }
    @Order(3)
    @Test
    void insertRoomTable(){
        Room livingRoom = roomRepository.findByName("거실").orElseThrow();
        Room frontRoom = roomRepository.findByName("앞방").orElseThrow();
        Room sideRoom = roomRepository.findByName("옆방").orElseThrow();

        List<MyTable> tableList = tableRepository.findAll();

        for(int i=0; i<tableList.size(); i++){
            RoomTable roomTable = new RoomTable();
            roomTable.setMyTable(tableList.get(i));
            if(i<5){
                roomTable.setRoom(livingRoom);
            }else if(i<8){
                roomTable.setRoom(frontRoom);
            }else {
                roomTable.setRoom(sideRoom);
            }
            roomTableRepository.save(roomTable);
        }
    }
    @Order(4)
    @Test
    void insertRoomTableCheck(){
        Room livingRoom = roomRepository.findByName("거실").orElseThrow();
        Room frontRoom = roomRepository.findByName("앞방").orElseThrow();
        Room sideRoom = roomRepository.findByName("옆방").orElseThrow();

        List<RoomTable>livingRoomTables = roomTableRepository.findByRoom(livingRoom);
        List<RoomTable>frontRoomTables = roomTableRepository.findByRoom(frontRoom);
        List<RoomTable>sideRoomTables = roomTableRepository.findByRoom(sideRoom);

        assertThat(livingRoomTables).hasSize(5);
        for(int i=0; i<5; i++){
            assertThat(livingRoomTables.get(i).getMyTable().getNumber()).isEqualTo(i+1);
        }
        assertThat(frontRoomTables).hasSize(3);
        for(int i=0; i<3; i++){
            assertThat(frontRoomTables.get(i).getMyTable().getNumber()).isEqualTo(i+6);
        }
        assertThat(sideRoomTables).hasSize(4);
        for(int i=0; i<4; i++){
            assertThat(sideRoomTables.get(i).getMyTable().getNumber()).isEqualTo(i+9);
        }
    }
}

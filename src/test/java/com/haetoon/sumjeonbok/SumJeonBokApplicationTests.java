package com.haetoon.sumjeonbok;

import com.haetoon.sumjeonbok.model.entity.*;
import com.haetoon.sumjeonbok.repository.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SumJeonBokApplicationTests {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private RoomTableRepository roomTableRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuInfoRepository menuInfoRepository;
    @Autowired
    private StatusRepository statusRepository;

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
    @Order(5)
    @Test
    void insertSize(){
        Size size1 = new Size();
        size1.setName("대");
        sizeRepository.save(size1);
        Size size2 = new Size();
        size2.setName("중");
        sizeRepository.save(size2);
        Size size3 = new Size();
        size3.setName("소");
        sizeRepository.save(size3);
        Size size4 = new Size();
        size4.setName("기본");
        sizeRepository.save(size4);
    }
    @Order(6)
    @Test
    void insertType(){
        Type type1 = new Type();
        type1.setName("메인");
        typeRepository.save(type1);
        Type type2 = new Type();
        type2.setName("서브");
        typeRepository.save(type2);
        Type type3 = new Type();
        type3.setName("주류");
        typeRepository.save(type3);
        Type type4 = new Type();
        type4.setName("음료");
        typeRepository.save(type4);
    }
    @Order(7)
    @Test
    void insertMenu(){
        Menu menu1 = new Menu();
        menu1.setName("전복해물찜");
        menuRepository.save(menu1);
        Menu menu2 = new Menu();
        menu2.setName("전복구이");
        menuRepository.save(menu2);
        Menu menu3 = new Menu();
        menu3.setName("전복물회");
        menuRepository.save(menu3);
        Menu menu4 = new Menu();
        menu4.setName("전복라면");
        menuRepository.save(menu4);
        Menu menu5 = new Menu();
        menu5.setName("전복덮밥");
        menuRepository.save(menu5);
        Menu menu6 = new Menu();
        menu6.setName("전복죽");
        menuRepository.save(menu6);
        Menu menu7 = new Menu();
        menu7.setName("소주");
        menuRepository.save(menu7);
        Menu menu8 = new Menu();
        menu8.setName("맥주");
        menuRepository.save(menu8);
        Menu menu9 = new Menu();
        menu9.setName("콜라");
        menuRepository.save(menu9);
    }
    @Order(8)
    @Test
    void insertMenuInfo(){
        Size big = sizeRepository.findByName("대").orElseThrow();
        Size middle = sizeRepository.findByName("중").orElseThrow();
        Size normal = sizeRepository.findByName("기본").orElseThrow();

        Type main = typeRepository.findByName("메인").orElseThrow();
        Type sub = typeRepository.findByName("서브").orElseThrow();
        Type alcohol = typeRepository.findByName("주류").orElseThrow();
        Type drink = typeRepository.findByName("음료").orElseThrow();

        Menu menu1 = menuRepository.findByName("전복해물찜").orElseThrow();
        Menu menu2 = menuRepository.findByName("전복구이").orElseThrow();
        Menu menu3 = menuRepository.findByName("전복물회").orElseThrow();
        Menu menu4 = menuRepository.findByName("전복라면").orElseThrow();
        Menu menu5 = menuRepository.findByName("전복덮밥").orElseThrow();
        Menu menu6 = menuRepository.findByName("전복죽").orElseThrow();
        Menu menu7 = menuRepository.findByName("소주").orElseThrow();
        Menu menu8 = menuRepository.findByName("맥주").orElseThrow();
        Menu menu9 = menuRepository.findByName("콜라").orElseThrow();

        MenuInfo menuInfo1 = MenuInfo.builder()
                .menu(menu1)
                .type(main)
                .size(big)
                .cost(0)
                .price(80000)
                .build();
        menuInfoRepository.save(menuInfo1);
        MenuInfo menuInfo2 = MenuInfo.builder()
                .menu(menu1)
                .type(main)
                .size(middle)
                .cost(0)
                .price(60000)
                .build();
        menuInfoRepository.save(menuInfo2);
        MenuInfo menuInfo3 = MenuInfo.builder()
                .menu(menu2)
                .type(main)
                .size(big)
                .cost(0)
                .price(60000)
                .build();
        menuInfoRepository.save(menuInfo3);
        MenuInfo menuInfo4 = MenuInfo.builder()
                .menu(menu2)
                .type(main)
                .size(middle)
                .cost(0)
                .price(40000)
                .build();
        menuInfoRepository.save(menuInfo4);
        MenuInfo menuInfo5 = MenuInfo.builder()
                .menu(menu3)
                .type(sub)
                .size(normal)
                .cost(0)
                .price(18000)
                .build();
        menuInfoRepository.save(menuInfo5);
        MenuInfo menuInfo6 = MenuInfo.builder()
                .menu(menu4)
                .type(sub)
                .size(normal)
                .cost(0)
                .price(10000)
                .build();
        menuInfoRepository.save(menuInfo6);
        MenuInfo menuInfo7 = MenuInfo.builder()
                .menu(menu5)
                .type(sub)
                .size(normal)
                .cost(0)
                .price(15000)
                .build();
        menuInfoRepository.save(menuInfo7);
        MenuInfo menuInfo8 = MenuInfo.builder()
                .menu(menu6)
                .type(sub)
                .size(normal)
                .cost(0)
                .price(15000)
                .build();
        menuInfoRepository.save(menuInfo8);
        MenuInfo menuInfo9 = MenuInfo.builder()
                .menu(menu7)
                .type(alcohol)
                .size(normal)
                .cost(0)
                .price(4000)
                .build();
        menuInfoRepository.save(menuInfo9);
        MenuInfo menuInfo10 = MenuInfo.builder()
                .menu(menu8)
                .type(alcohol)
                .size(normal)
                .cost(0)
                .price(4000)
                .build();
        menuInfoRepository.save(menuInfo10);
        MenuInfo menuInfo11 = MenuInfo.builder()
                .menu(menu9)
                .type(drink)
                .size(normal)
                .cost(0)
                .price(3000)
                .build();
        menuInfoRepository.save(menuInfo11);
    }
    @Order(9)
    @Test
    void insertMenuInfoCheck() {
        // Size와 Type, Menu 엔티티를 데이터베이스에서 불러오기
        Size big = sizeRepository.findByName("대").orElseThrow();
        Size middle = sizeRepository.findByName("중").orElseThrow();
        Size normal = sizeRepository.findByName("기본").orElseThrow();

        Type main = typeRepository.findByName("메인").orElseThrow();
        Type sub = typeRepository.findByName("서브").orElseThrow();
        Type alcohol = typeRepository.findByName("주류").orElseThrow();
        Type drink = typeRepository.findByName("음료").orElseThrow();

        Menu menu1 = menuRepository.findByName("전복해물찜").orElseThrow();
        Menu menu2 = menuRepository.findByName("전복구이").orElseThrow();
        Menu menu3 = menuRepository.findByName("전복물회").orElseThrow();
        Menu menu4 = menuRepository.findByName("전복라면").orElseThrow();
        Menu menu5 = menuRepository.findByName("전복덮밥").orElseThrow();
        Menu menu6 = menuRepository.findByName("전복죽").orElseThrow();
        Menu menu7 = menuRepository.findByName("소주").orElseThrow();
        Menu menu8 = menuRepository.findByName("맥주").orElseThrow();
        Menu menu9 = menuRepository.findByName("콜라").orElseThrow();

        // MenuInfo 엔트리의 개수 확인
        long count = menuInfoRepository.count();
        assertEquals(11, count, "MenuInfo 엔트리 수는 11개여야 합니다.");

        // 특정 MenuInfo 엔트리 확인
        MenuInfo menuInfo1 = menuInfoRepository.findByMenuAndTypeAndSize(menu1, main, big).orElseThrow();
        assertEquals(80000, menuInfo1.getPrice(), "'전복해물찜'의 '대' 크기 가격은 80000이어야 합니다.");

        MenuInfo menuInfo2 = menuInfoRepository.findByMenuAndTypeAndSize(menu1, main, middle).orElseThrow();
        assertEquals(60000, menuInfo2.getPrice(), "'전복해물찜'의 '중' 크기 가격은 60000이어야 합니다.");

        MenuInfo menuInfo3 = menuInfoRepository.findByMenuAndTypeAndSize(menu2, main, big).orElseThrow();
        assertEquals(60000, menuInfo3.getPrice(), "'전복구이'의 '대' 크기 가격은 60000이어야 합니다.");

        MenuInfo menuInfo4 = menuInfoRepository.findByMenuAndTypeAndSize(menu2, main, middle).orElseThrow();
        assertEquals(40000, menuInfo4.getPrice(), "'전복구이'의 '중' 크기 가격은 40000이어야 합니다.");

        MenuInfo menuInfo5 = menuInfoRepository.findByMenuAndTypeAndSize(menu3, sub, normal).orElseThrow();
        assertEquals(18000, menuInfo5.getPrice(), "'전복물회'의 '기본' 크기 가격은 18000이어야 합니다.");

        MenuInfo menuInfo6 = menuInfoRepository.findByMenuAndTypeAndSize(menu4, sub, normal).orElseThrow();
        assertEquals(10000, menuInfo6.getPrice(), "'전복라면'의 '기본' 크기 가격은 10000이어야 합니다.");

        MenuInfo menuInfo7 = menuInfoRepository.findByMenuAndTypeAndSize(menu5, sub, normal).orElseThrow();
        assertEquals(15000, menuInfo7.getPrice(), "'전복덮밥'의 '기본' 크기 가격은 15000이어야 합니다.");

        MenuInfo menuInfo8 = menuInfoRepository.findByMenuAndTypeAndSize(menu6, sub, normal).orElseThrow();
        assertEquals(15000, menuInfo8.getPrice(), "'전복죽'의 '기본' 크기 가격은 15000이어야 합니다.");

        MenuInfo menuInfo9 = menuInfoRepository.findByMenuAndTypeAndSize(menu7, alcohol, normal).orElseThrow();
        assertEquals(4000, menuInfo9.getPrice(), "'소주'의 '기본' 크기 가격은 4000이어야 합니다.");

        MenuInfo menuInfo10 = menuInfoRepository.findByMenuAndTypeAndSize(menu8, alcohol, normal).orElseThrow();
        assertEquals(4000, menuInfo10.getPrice(), "'맥주'의 '기본' 크기 가격은 4000이어야 합니다.");

        MenuInfo menuInfo11 = menuInfoRepository.findByMenuAndTypeAndSize(menu9, drink, normal).orElseThrow();
        assertEquals(3000, menuInfo11.getPrice(), "'콜라'의 '기본' 크기 가격은 3000이어야 합니다.");
    }
    @Order(10)
    @Test
    void insertStatus(){
        Status status1 = new Status();
        status1.setName("결제전");
        statusRepository.save(status1);
        Status status2 = new Status();
        status2.setName("결제후");
        statusRepository.save(status2);
    }
    @Order(11)
    @Test
    void statusInsertTest(){
        Status no = statusRepository.findByName("결제전").orElseThrow();
        Status yes = statusRepository.findByName("결제후").orElseThrow();

    }
}

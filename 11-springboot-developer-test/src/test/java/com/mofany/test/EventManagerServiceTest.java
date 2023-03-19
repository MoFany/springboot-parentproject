package com.mofany.test;

import com.mofany.entity.EventManager;
import com.mofany.service.EventManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description EventManagerServiceTest
 */
@SpringBootTest
public class EventManagerServiceTest {
    @Autowired
    private EventManagerService service;

    @Test
    public void test1(){
        System.out.println(service.queryAllEvent());
    }

    @Test
    public void test2(){
        EventManager eventManager=new EventManager();
        eventManager.setEventName("维修电脑");
        eventManager.setEventAddress("厦门软件园");
        eventManager.setStartStatus(-1);
        System.out.println(service.insertOneEvent(eventManager));
    }
}

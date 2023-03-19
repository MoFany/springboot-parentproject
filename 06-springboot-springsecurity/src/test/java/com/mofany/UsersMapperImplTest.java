package com.mofany;

import com.mofany.entity.Users;
import com.mofany.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description UsersMapperImplTest
 */
@SpringBootTest
public class UsersMapperImplTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test1(){
        List<Users> userList = usersMapper.selectList(null);
        userList.stream().forEach(System.out::println);
    }
}

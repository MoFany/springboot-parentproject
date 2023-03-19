package com.mofany.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mofany.entity.Users;
import com.mofany.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description UserDetailsServiceImpl
 */
@Service("suerDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;


    /**
     * 按中户名加载用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户输入的用户名去查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = usersMapper.selectOne(wrapper);
        //判断，数据库中不存在该用户则认证失败
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        //进行验证
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_root");
        //从查询数据库中返回users对象，得到用户名与密码并返回
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}

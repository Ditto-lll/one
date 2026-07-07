package com.shanzhu.st.service.impl;

import com.shanzhu.st.entity.User;
import com.shanzhu.st.mapper.UserMapper;
import com.shanzhu.st.service.UserService;
import com.shanzhu.st.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User userLogin(String accountNumber, String userPassword) {
        return userMapper.userLogin(accountNumber, userPassword);
    }

    public boolean userSignIn(User user) {
        return userMapper.insert(user) == 1;
    }

    public boolean updateUserInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user) == 1;
    }

    public boolean updatePassword(String newPassword, String oldPassword, Long id) {
        return userMapper.updatePassword(newPassword, oldPassword, id) == 1;
    }

    // 删除以下方法 ↓
    // public PageVo<User> getUserByStatus(int status, int page, int nums) {
    //     ...
    // }

}
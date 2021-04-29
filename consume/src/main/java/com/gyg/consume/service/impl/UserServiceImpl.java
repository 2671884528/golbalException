package com.gyg.consume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gyg.consume.base.exception.GlobalException;
import com.gyg.consume.base.exception.SystemCode;
import com.gyg.consume.entity.User;
import com.gyg.consume.mapper.UserMapper;
import com.gyg.consume.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 * @author gyg
 * @since 2021-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void insert(User user) {
        save(user);
    }

    @Override
    public User selectOne(String id) throws GlobalException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        String rex = "[0-9]*";
        if (!Pattern.matches(rex,id)) {
            throw new GlobalException(SystemCode.ParameterValidError);
        }
        wrapper.eq("id",id);
        User one = getOne(wrapper);
        if (ObjectUtils.isEmpty(one)) {
            throw new GlobalException(SystemCode.ParameterValidNotExit);
        }
        return one;
    }
}

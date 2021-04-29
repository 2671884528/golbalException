package com.gyg.consume.service;

import com.gyg.consume.base.exception.GlobalException;
import com.gyg.consume.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gyg
 * @since 2021-04-28
 */
public interface UserService extends IService<User> {

    void insert(User user);

    User selectOne(String id) throws GlobalException;
}

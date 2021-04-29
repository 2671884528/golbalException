package com.gyg.consume.controller;


import com.gyg.consume.base.R;
import com.gyg.consume.base.exception.GlobalException;
import com.gyg.consume.entity.User;
import com.gyg.consume.client.ProductService;
import com.gyg.consume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gyg
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/consume/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    /**
     * 插入用户
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody User user){
        userService.insert(user);
        return R.ok().message("插入成功");
    }

    @GetMapping("/get/{id}")
    public R getOne(@PathVariable String id) throws GlobalException {
        User user = userService.selectOne(id);
        return R.ok().data("user",user);
    }


    /**
     * 查询所有的user
     * @return
     */
    @GetMapping("/list")
    public R list(){
        List<User> list = userService.list();
        return R.ok().data("userlist",list);
    }

    /**
     * 调用远程provider模块接口
     * @return product的list集合
     */
    @GetMapping("/getProductList")
    public R getProductList(){
        return productService.list();
    }


}


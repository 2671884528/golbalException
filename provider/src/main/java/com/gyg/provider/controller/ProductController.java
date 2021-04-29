package com.gyg.provider.controller;


import com.gyg.provider.base.R;
import com.gyg.provider.client.UserService;
import com.gyg.provider.entity.Product;
import com.gyg.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gyg
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/provider/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public R insert(@RequestBody Product product) {
        productService.insert(product);
        return R.ok().message("插入成功");
    }

    @GetMapping("/list")
    public R list() {
        List<Product> list = productService.list();
        return R.ok().data("productlist", list);
    }

    @GetMapping("/getUser/{id}")
    public R getUser(@PathVariable String id){
        return userService.getOne(id);
    }
}


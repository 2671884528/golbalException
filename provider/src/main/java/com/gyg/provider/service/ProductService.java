package com.gyg.provider.service;

import com.gyg.provider.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gyg
 * @since 2021-04-28
 */
public interface ProductService extends IService<Product> {

    void insert(Product product);
}

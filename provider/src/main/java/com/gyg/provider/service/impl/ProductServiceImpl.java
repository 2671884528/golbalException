package com.gyg.provider.service.impl;

import com.gyg.provider.entity.Product;
import com.gyg.provider.mapper.ProductMapper;
import com.gyg.provider.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gyg
 * @since 2021-04-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public void insert(Product product) {
        save(product);
    }
}

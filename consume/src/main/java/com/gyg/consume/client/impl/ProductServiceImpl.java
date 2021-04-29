package com.gyg.consume.client.impl;

import com.gyg.consume.base.R;
import com.gyg.consume.base.exception.GlobalException;
import com.gyg.consume.base.exception.SystemCode;
import com.gyg.consume.client.ProductService;
import org.springframework.stereotype.Component;

/**
 * @author 郭永钢
 */
@Component
public class ProductServiceImpl implements ProductService {

    /**
     * 服务降级，代替异常
     * @return
     */
    @Override
    public R list() {
        return null;
    }
}

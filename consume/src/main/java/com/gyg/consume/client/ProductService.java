package com.gyg.consume.client;

import com.gyg.consume.base.R;
import com.gyg.consume.client.impl.ProductServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guoyonggang
 */
@FeignClient(name = "provider",fallback = ProductServiceImpl.class)
@Component
public interface ProductService {

    /**
     * 调用provide模块的，Product接口，查询所有的产品
     *
     * @return R
     */
    @GetMapping(value = "/provider/product/list")
    R list();
}

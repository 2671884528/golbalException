package com.gyg.provider.client;

import com.gyg.provider.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consume")
@Component
public interface UserService {
    /**
     * 调用远程consume的接口，查询单个用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/consume/user/get/{id}")
    R getOne(@PathVariable("id") String id);


}

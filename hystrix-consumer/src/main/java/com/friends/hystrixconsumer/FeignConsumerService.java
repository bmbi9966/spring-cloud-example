package com.friends.hystrixconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name="hystrixClient",fallback = HystrixClientFallback.class)
public interface FeignConsumerService {
    @GetMapping("getInstanceInfoOverTime")
    String getInstanceInfoFromFeign();
}

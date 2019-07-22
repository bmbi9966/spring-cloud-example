package com.friends.hystrixconsumer;

import org.springframework.stereotype.Component;

@Component
public  class HystrixClientFallback  implements FeignConsumerService  {
    @Override
    public String getInstanceInfoFromFeign() {
        return "FeignFallback";
    }
}

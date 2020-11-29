package com.muc.zuul.feign;
import com.muc.zuul.model.ReqLoginVo;
import com.muc.zuul.model.RespLoginVo;
import com.muc.zuul.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userservice")
public interface UserServiceFeignClient {
    @PostMapping("/userservice/api/v1/login")
    public Result<RespLoginVo> login(@RequestBody ReqLoginVo request);
}

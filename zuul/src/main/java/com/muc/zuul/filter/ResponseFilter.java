package com.muc.zuul.filter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.muc.zuul.model.RespLoginVo;
import com.muc.zuul.model.Result;
import com.muc.zuul.model.ResultGenerator;
import com.muc.zuul.model.Token;
import com.muc.zuul.pool.TokenPool;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

@Component
@Slf4j
public class ResponseFilter extends ZuulFilter {
    @Autowired
    private TokenPool tokenPool;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @SneakyThrows
    @Override
    public Object run() throws ZuulException {
        //得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response=currentContext.getResponse();
        log.info("返回值过滤");
        if(request.getRequestURI().indexOf("login")>0){
            InputStream stream = currentContext.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));

            if (StringUtils.isNotBlank(body)) {

                Result result = new Gson().fromJson(body, Result.class);
                String dataJson=new Gson().toJson(result.getData());
                RespLoginVo data=new Gson().fromJson(dataJson, RespLoginVo.class);
                Token token=Token.builder()
                        .apiToken(data.getApiToken())
                        .expire(data.getExpireTime())
                        .build();
                if(tokenPool.getTokens().get(data.getCid())==null||tokenPool.getTokens().get(data.getCid()).isTimeout()) {
                    tokenPool.getTokens().put(data.getCid(), token);
                }
                else{
                    Result result1=ResultGenerator.genErrorResult(201,"请勿重复登录");
                    result1.setData(data);
                    body=new Gson().toJson(result1);
                }
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
                currentContext.setResponseBody(body);
            }
        }
        return null;
    }
}
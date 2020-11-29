package com.muc.zuul.pool;

import com.muc.zuul.model.Token;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Component
@Data
public class TokenPool{
  public  Map<String, Token> tokens = Collections.synchronizedMap(new HashMap<String,Token>());
}

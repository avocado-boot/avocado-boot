package com.avocado.boot.starter.oauth.controller;

import cn.hutool.http.HttpStatus;
import com.avocado.boot.starter.oauth.application.OauthLoginManager;
import com.avocado.boot.starter.oauth.application.dto.OauthParameter;
import com.avocado.boot.starter.security.annotation.PreAuthorize;
import com.avocado.boot.starter.security.bean.AccessToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ：qiaoliang
 */
@RestController
public class OauthController {

    private final OauthLoginManager oauthLoginManager;

    public OauthController(OauthLoginManager oauthLoginManager) {
        this.oauthLoginManager = oauthLoginManager;
    }

    /**
     * 获取访问令牌
     *
     * @author ：qiaoliang
     * @param parameter : 请求参数
     * @return org.springframework.http.ResponseEntity<com.avocado.boot.starter.security.bean.AccessToken>
     */
    @PostMapping(value = "/oauth/token")
    public ResponseEntity<AccessToken> getToken(@Valid @RequestBody OauthParameter parameter)
            throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.HTTP_CREATED)
                .body(oauthLoginManager.getAccessToken(parameter));
    }

    /**
     * 获取code
     *
     * @author ：qiaoliang
     * @param parameter : 请求参数
     * @return org.springframework.http.ResponseEntity<java.lang.String>
     */
    @PreAuthorize
    @PostMapping(value = "/code")
    public ResponseEntity<String> applyCode(@Valid @RequestBody OauthParameter parameter){
        return ResponseEntity.status(HttpStatus.HTTP_CREATED)
                .body(oauthLoginManager.getCode(parameter));
    }

}

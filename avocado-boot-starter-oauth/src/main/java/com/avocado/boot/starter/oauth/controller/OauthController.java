package com.avocado.boot.starter.oauth.controller;

import cn.hutool.http.HttpStatus;
import com.avocado.boot.starter.log.invalid.Log;
import com.avocado.boot.starter.oauth.application.command.OauthClientCmd;
import com.avocado.boot.starter.oauth.application.command.cmd.OauthCommand;
import com.avocado.boot.starter.security.annotation.PreAuthorize;
import com.avocado.boot.starter.security.bean.AccessToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author ：qiaoliang
 */
@Api(tags = "Oauth认证模块")
@Validated
@RequestMapping("/oauth")
@RestController
public class OauthController {

    private final OauthClientCmd oauthClientCmd;

    public OauthController(OauthClientCmd oauthClientCmd) {
        this.oauthClientCmd = oauthClientCmd;
    }

    @ApiOperation(value = "获取访问令牌")
    @Log(discription = "获取访问令牌")
    @PostMapping(value = "/token")
    public ResponseEntity<AccessToken> getToken(@Valid @RequestBody OauthCommand parameter) {
        return ResponseEntity.status(HttpStatus.HTTP_CREATED)
                .body(oauthClientCmd.getAccessToken(parameter));
    }

    @ApiOperation(value = "获取code")
    @PreAuthorize
    @Log(discription = "获取code")
    @PostMapping(value = "/code")
    public ResponseEntity<String> applyCode(@Valid @RequestBody OauthCommand parameter){
        return ResponseEntity.status(HttpStatus.HTTP_CREATED)
                .body(oauthClientCmd.getCode(parameter));
    }

}

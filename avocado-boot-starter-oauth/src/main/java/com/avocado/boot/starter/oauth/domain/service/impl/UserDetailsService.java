package com.avocado.boot.starter.oauth.domain.service.impl;

import com.avocado.boot.starter.core.exception.BusinessException;
import com.avocado.boot.starter.oauth.domain.UserDetails;
import com.avocado.boot.starter.oauth.domain.service.IUserDetailsService;
import org.springframework.stereotype.Component;

import static com.avocado.boot.starter.oauth.infrastructure.enums.OauthErrorType.NON_USER_ERROR;

/**
 * @author ：qiaoliang
 */
public class UserDetailsService implements IUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        throw new BusinessException(NON_USER_ERROR);
    }

}

package com.avocado.boot.starter.security.bean;


import java.util.ArrayList;
import java.util.Collection;

/**
 * 账号的认证信息
 *
 * @author ：qiaoliang
 */
public class Authentication implements java.io.Serializable {

    /**主键**/
    private Long id;

    /**权限列表**/
    private Collection<String> authorities;

    /**有效期时间**/
    private Long expiresIn;

    public Authentication() {
    }

    public Authentication(Long id, Collection<String> authorities, Long expiresIn) {
        this.id = id;
        this.authorities = authorities;
        this.expiresIn = expiresIn;
    }

    public Authentication(Long id) {
        this.id = id;
        this.authorities = new ArrayList<>();
    }

    public Authentication(Long id, Long expiresIn) {
        this.id = id;
        this.expiresIn = expiresIn;
        this.authorities = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}

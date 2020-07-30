package com.avocado.boot.starter.oauth.domain;

import java.util.Collection;

/**
 * @author ：qiaoliang
 */
public class UserDetails {
    /**用户ID**/
    private Long userId;

    /**密码**/
    private String password;

    /**权限列表**/
    private Collection<String> authorities;

    /**用户是否未过期**/
    private boolean accountNonExpired = false;

    /**用户是否未锁定**/
    private boolean accountNonLocked = false;

    /**凭证是否未过期**/
    private boolean credentialsNonExpired = false;

    /**是否启用**/
    private boolean enabled = false;

    public UserDetails(Long userId, String password, Collection<String> authorities) {
        this.userId = userId;
        this.password = password;
        this.authorities = authorities;
    }

    public UserDetails(Long userId, String password, Collection<String> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.userId = userId;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

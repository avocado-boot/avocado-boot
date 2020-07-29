package com.avocado.boot.starter.security.context;

import com.avocado.boot.starter.security.bean.Authentication;

import java.util.Collection;

/**
 * 上下文处理器
 *
 * @author ：qiaoliang
 */
public class SecurityContextHolder {

    private static final ThreadLocal<Authentication> THREAD_LOCAL = new ThreadLocal<>();

    public static void clear(){
        THREAD_LOCAL.remove();
    }

    public static void set(Authentication authentication){
        THREAD_LOCAL.set(authentication);
    }

    public static Authentication getAuthentication(){
        return THREAD_LOCAL.get();
    }

    public static Long getId(){
        return THREAD_LOCAL.get().getId();
    }

    public static Collection<String> getAuthorities(){
        return THREAD_LOCAL.get().getAuthorities();
    }

}

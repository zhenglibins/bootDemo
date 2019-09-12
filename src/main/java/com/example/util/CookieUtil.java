package com.example.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {

    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 从cookie中取值
     *
     * @param key
     * @return
     */
    public static String getCookie(String key) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        Cookie cookie = WebUtils.getCookie(request, key);
        if (cookie != null && StringUtils.isBlank(cookie.getValue())) {
            String ckValue = cookie.getValue();
            try {
                ckValue = URLDecoder.decode(ckValue, "UTF-8");
            } catch (UnsupportedEncodingException e1) {
                //
            }
            return ckValue;
        }
        return null;
    }

    /**
     * 设置cookies
     *
     * @param key
     * @param value
     * @param enCrypt
     */
    public static void setCookie(String key, String value, boolean enCrypt) {
        setCookie(null, key, value, enCrypt, null);
    }

    public static void setCookie(String key, String value, boolean enCrypt, Integer maxAge) {
        setCookie(null, key, value, enCrypt, maxAge);
    }

    public static void setCookie(String domain, String key, String value, boolean enCrypt, Integer maxAge) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse resp = attrs.getResponse();
        if(StringUtils.isNotEmpty(value)) {
            try {
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("setCookie(HttpServletResponse resp, String key,T value,boolean encode)", e);
            }
        }
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        if (!StringUtils.isBlank(domain)) {
            cookie.setDomain(domain);
        }
        if (maxAge != null) {
            cookie.setMaxAge(maxAge);
        }
        resp.addCookie(cookie);
    }

    /**
     * 清空当前域的指定的cookie
     *
     * @param key
     */
    public static void clearCookie(String key) {
        clearCookie(null, key);
    }

    public static void clearCookie(String domain, String key) {

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse resp = attrs.getResponse();
        Cookie cookie = new Cookie(key, null);
        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setPath("/");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
}

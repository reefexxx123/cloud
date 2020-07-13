package com.xxxJppp.cloud.common.utils;

import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * 获取上下文
 *
 * @author xxxJppp
 * @date 2020/6/2 16:33
 */
public class ContextUtil {
    public static Class MainClass;
    private static ConfigurableApplicationContext applicationContext;

    public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        ContextUtil.applicationContext = applicationContext;
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> type, boolean required) {
        if (type != null && applicationContext != null) {
            if (required) {
                return applicationContext.getBean(type);
            } else {
                if (applicationContext.getBeansOfType(type).size() > 0) {
                    return applicationContext.getBean(type);
                }
            }
        }
        return null;
    }

    public static Object getBean(String type, boolean required) {
        if (type != null && applicationContext != null) {
            if (required) {
                return applicationContext.getBean(type);
            } else {
                if (applicationContext.containsBean(type)) {
                    return applicationContext.getBean(type);
                }
            }
        }
        return null;
    }

    public static ConfigurableWebServerApplicationContext getConfigurableWebServerApplicationContext() {
        ApplicationContext context = ContextUtil.getApplicationContext();
        if (context instanceof ConfigurableWebServerApplicationContext) {
            return (ConfigurableWebServerApplicationContext) context;
        }
        return null;
    }

    public static boolean isWeb() {
        return getConfigurableWebServerApplicationContext() != null;
    }

    public static String getBeanDefinitionText() {
        String[] beans = getApplicationContext().getBeanDefinitionNames();
        Arrays.sort(beans);
        StringBuilder sb = new StringBuilder();
        for (String bean : beans) {
            sb.append(bean).append(" -> ").append(ContextUtil.getApplicationContext().getBean(bean).getClass());
        }
        return sb.toString();
    }
}

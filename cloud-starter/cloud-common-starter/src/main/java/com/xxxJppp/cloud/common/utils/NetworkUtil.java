package com.xxxJppp.cloud.common.utils;

import org.springframework.util.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * NetworkUtils
 *
 * @author xxxJppp
 * @date 2020/6/2 16:37
 */
public class NetworkUtil {

    public static String getIpAddress() {
        String ipExclude = "";
        if (org.springframework.util.StringUtils.hasText(ipExclude)) {
            String regex = buildRegex(ipExclude);
            return getIpAddressExMatched(regex);
        }

        String ipInclude = "";
        if (org.springframework.util.StringUtils.hasText(ipInclude)) {
            String regex = buildRegex(ipInclude);
            return getIpAddressMatched(regex);
        }

        return getIpAddress0();
    }

    public static String getIpAddress0() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp() || netInterface.isPointToPoint()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    /**
     * 获取指定网段地址
     *
     * @param regex 10.0.18 网址前两个或前三个地址段
     */
    public static String getIpAddressMatched(String regex) {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            String strIp = ip.getHostAddress();
                            //如果匹配网段则返回
                            if (Pattern.matches(regex, strIp)) {
                                return strIp;
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    /**
     * 获取指定网段地址，
     *
     * @param regex 10.0.18 排除地址段，两个或前三个地址段
     */
    public static String getIpAddressExMatched(String regex) {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            String strIp = ip.getHostAddress();
                            //如果不匹配匹配网段则返回;
                            if (!Pattern.matches(regex, strIp)) {
                                return strIp;
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    /**
     * 构建正在表达式
     */
    private static String buildRegex(String source) {
        StringBuilder sb = new StringBuilder();
        String[] strSource = source.split(",");
        for (int i = 0; i < strSource.length; i++) {
            sb.append("|(^").append(strSource[i]).append(".*)");
        }
        String regex = sb.toString();
        if (!StringUtils.isEmpty(regex)) {
            //去掉开头|号
            return regex.substring(1);
        }
        return "";
    }
}

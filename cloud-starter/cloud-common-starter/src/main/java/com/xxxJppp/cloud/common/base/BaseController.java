package com.xxxJppp.cloud.common.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxJppp.cloud.common.utils.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author xxxJppp
 * @version 1.0
 * @date 2020/7/1
 */
public abstract class BaseController {

    /**
     * 获取当前请求对象
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * getParameter系列的方法主要用于处理“请求数据”，是服务器端程序获取浏览器所传递参数的主要接口。
     *
     * @param name 表单name属性
     * @return
     */
    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * getParameterValues这个方法是获得传过来的参数名相同的一个数组;
     *
     * @param name
     * @return
     */
    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    /**
     * getAttribute这个方法是提取放置在某个共享区间的对象
     *
     * @param name
     * @return
     */
    public Object getAttribute(String name) {
        return getRequest().getSession().getAttribute(name);
    }

    /**
     * 返回的是相对路径，工程的项目的相对路径
     *
     * @return
     */
    public String getContextPath() {
        return getRequest().getContextPath();
    }

    /**
     * 重定向至地址 url
     *
     * @param url 请求地址
     * @return
     */
    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    /**
     * 获取页面地址url
     *
     * @param path
     * @return
     */
    protected static String getViewPath(String path) {
        StringBuffer viewPath = new StringBuffer();
        viewPath.append(path);
        return viewPath.toString();
    }

    /**
     * 生成随机数
     *
     * @param count 生成个数
     * @return String
     */
    protected String getRandomNum(int count) {
        Random ra = new Random();
        String random = "";
        for (int i = 0; i < count; i++) {
            random += ra.nextInt(9);
        }
        return random;
    }

    /**
     * 返回boolean值（用于判断查询是升序，还是降序）
     *
     * @param orderSort 是否升序
     * @return boolean
     */
    protected boolean getOrderSort(String orderSort) {
        if (orderSort == null || "".equals(orderSort)) return true;
        if ("asc".equals(orderSort)) return true;
        return false;
    }

    /**
     * 获取分页 排序
     *
     * @return Page
     */
    protected Page getPage() {
        int pageSize = 10;
        try {
            if (getParameter("pageSize") != null && !"".equals(getParameter("pageSize"))) {
                pageSize = Integer.parseInt(getParameter("pageSize"));
            }
        } catch (NumberFormatException e) {

        }
        int pageNumber = 1; // 起始行数
        try {
            if (getParameter("pageNumber") != null && !"".equals(getParameter("pageNumber"))) {
                pageNumber = Integer.parseInt(getParameter("pageNumber"));
            }
        } catch (NumberFormatException e) {
        }
        Page page = new Page(pageNumber, pageSize); // (页数，页面大小)
        //排序
        String sort = getParameter("sortField");
        boolean sortOrder = getOrderSort(getParameter("sortOrder"));
        if (StringUtils.isNotEmpty(sort)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(sortOrder);
            orderItem.setColumn(sort);
            List<OrderItem> orders = new ArrayList<>();
            orders.add(orderItem);
            page.setOrders(orders);
        }
        return page;
    }
}

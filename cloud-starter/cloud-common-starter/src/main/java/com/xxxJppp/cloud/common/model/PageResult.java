package com.xxxJppp.cloud.common.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxxJppp.cloud.common.enums.ResultEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 *
 * @author xxxJppp
 * @date 2020/4/29 15:40
 */
@Data
@Builder
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -275582248840137389L;

    private int code;
    private String message;
    private long total;
    private long pageSize;
    private long currentPage;
    private List<T> data;

    public static <T> PageResult<T> succeed(IPage<T> page) {
        return PageResult.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .total(page.getTotal())
                .pageSize(page.getSize())
                .currentPage(page.getCurrent())
                .data(page.getRecords())
                .build();
    }

    public static <T> PageResult<T> succeed(IPage<T> page, ResultEnum resultEnum) {
        return PageResult.<T>builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .total(page.getTotal())
                .pageSize(page.getSize())
                .currentPage(page.getCurrent())
                .data(page.getRecords())
                .build();
    }

    public static <T> PageResult<T> succeed(long total,
                                            long pageSize,
                                            long currentPage,
                                            List<T> data) {
        return PageResult.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .total(total)
                .pageSize(pageSize)
                .currentPage(currentPage)
                .data(data)
                .build();
    }

    public static <T> PageResult<T> of(Integer code,
                                       String msg,
                                       long total,
                                       long pageSize,
                                       long currentPage,
                                       List<T> data) {
        return new PageResult<>(code, msg, total, pageSize, currentPage, data);
    }

}

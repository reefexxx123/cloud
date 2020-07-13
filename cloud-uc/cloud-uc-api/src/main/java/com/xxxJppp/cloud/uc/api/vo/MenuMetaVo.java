package com.xxxJppp.cloud.uc.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 菜单DTO
 *
 * @author xxxJppp
 * @date 2020/5/14 10:44
 */
@Data
@AllArgsConstructor
public class MenuMetaVo implements Serializable {

    private String title;
    private String icon;
}

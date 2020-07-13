package com.xxxJppp.cloud.uc.api.vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单
 *
 * @author xxxJppp
 * @date 2020/5/14 10:44
 */
@Data
public class MenuVo {

    private String name;
    private String path;
    private String redirect;
    private String component;
    private Boolean alwaysShow;
    private MenuMetaVo meta;
    private List<MenuVo> children;
}

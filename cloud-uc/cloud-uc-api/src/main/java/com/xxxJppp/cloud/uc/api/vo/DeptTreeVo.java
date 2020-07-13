package com.xxxJppp.cloud.uc.api.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 构建部门树vo
 *
 * @author xxxJppp
 * @date 2020/5/2 16:42
*/
@Setter
@Getter
@ToString
public class DeptTreeVo {

    /** 对应SysDepart中的id字段,前端数据树中的key*/
    private int key;
    /** 对应SysDepart中的id字段,前端数据树中的value*/
    private String value;
    /** 对应depart_name字段,前端数据树中的title*/
    private String title;

    private List<DeptTreeVo> children;

}

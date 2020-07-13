package com.xxxJppp.cloud.uc.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxJppp.cloud.uc.api.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 后台系统菜单 Mapper 接口
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<String> selectMenuPermsByUserId(Long userId);
}

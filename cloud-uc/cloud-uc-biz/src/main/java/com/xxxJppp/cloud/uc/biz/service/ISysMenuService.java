package com.xxxJppp.cloud.uc.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxJppp.cloud.uc.api.entity.SysMenu;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 后台系统菜单 服务类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<String> findMenusByUserId(Long userId);

    Set<String> selectMenuPermsByUserId(Long userId);
}

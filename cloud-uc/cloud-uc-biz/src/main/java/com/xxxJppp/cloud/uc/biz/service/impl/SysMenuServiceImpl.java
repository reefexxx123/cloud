package com.xxxJppp.cloud.uc.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxJppp.cloud.common.utils.StringUtils;
import com.xxxJppp.cloud.uc.api.entity.SysMenu;
import com.xxxJppp.cloud.uc.biz.dao.SysMenuMapper;
import com.xxxJppp.cloud.uc.biz.service.ISysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 后台系统菜单 服务实现类
 * </p>
 *
 * @author xxxJppp
 * @since 2020-06-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {


    @Override
    public List<String> findMenusByUserId(Long userId) {
        return null;
    }


    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        List<String> perms = baseMapper.selectMenuPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        if(!CollectionUtils.isEmpty(perms)){
            for (String perm : perms) {
                if (StringUtils.isNotEmpty(perm)) {
                    permsSet.addAll(Arrays.asList(perm.trim().split(",")));
                }
            }
        }
        return permsSet;
    }
}

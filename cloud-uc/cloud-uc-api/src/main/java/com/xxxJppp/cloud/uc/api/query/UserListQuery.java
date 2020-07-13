package com.xxxJppp.cloud.uc.api.query;

import lombok.Data;

/**
 * 用户查询DTO
 *
 * @author xxxJppp
 * @date 2020/5/14 10:44
 */
@Data
public class UserListQuery{
    private Integer userId;
    private String nickname;
    private String username;
    private Integer deptId;
    private Integer jobId;
    private String mobile;
    private String email;
}

package com.xxxJppp.cloud.tenant.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 初始化数据库DAO
 *
 * @author zuihou
 * @date 2019/09/02
 */
@Repository
@SqlParser(filter = true)
public interface InitDbMapper extends BaseMapper {
    /**
     * 创建数据库
     *
     * @param database
     * @return
     */
    @Update("<script>" +
            " CREATE DATABASE IF NOT EXISTS #{database} DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci" +
            " </script>")
    int createDatabase(@Param("database") String database);


    /**
     * 删除数据库
     *
     * @param database
     * @return
     */
    @Update("<script>" +
            " DROP DATABASE IF EXISTS #{database}" +
            " </script>")
    int dropDatabase(@Param("database") String database);

}

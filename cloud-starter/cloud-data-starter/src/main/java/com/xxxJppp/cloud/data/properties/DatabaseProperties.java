package com.xxxJppp.cloud.data.properties;

import com.xxxJppp.cloud.common.constant.StarterNameConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 客户端认证配置
 *
 * @author zuihou
 * @date 2018/11/20
 */
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "cloud.data")
@Data
public class DatabaseProperties {

    public DatabaseProperties() {
        log.info("[CLOUD][" + StarterNameConstant.CLOUD_DATA_STARTER + "]" + "，加载[DatabaseProperties]配置");
    }

    /**
     * 攻击 SQL 阻断解析器
     *
     * @return
     */
    public Boolean isBlockAttack = false;
    /**
     * 是否启用 seata
     */
    public Boolean isSeata = false;
    /**
     * 分页大小限制
     */
    protected long limit = -1;
    /**
     * 是否禁止写入
     */
    private Boolean isNotWrite = false;
    /**
     * 是否启用数据权限
     */
    private Boolean isDataScope = true;
    /**
     * 事务超时时间
     */
    private int txTimeout = 60 * 60;

    /**
     * Id 生成策略
     */
    private Id id = new Id();

    /**
     * 统一管理事务的方法名
     */
    private List<String> transactionAttributeList = new ArrayList<>(Arrays.asList("add*", "save*", "insert*",
            "create*", "update*", "edit*", "upload*", "delete*", "remove*",
            "clean*", "recycle*", "batch*", "mark*", "disable*", "enable*", "handle*", "syn*",
            "reg*", "gen*", "*Tx"
    ));
    /**
     * 事务扫描基础包
     */
    private String transactionScanPackage = "com.xxxJppp.cloud";

    @Data
    public static class Id {
        /**
         * 终端ID (0-31)      单机配置0 即可。 集群部署，根据情况每个实例自增即可。
         */
        private Long workerId = 0L;
        /**
         * 数据中心ID (0-31)   单机配置0 即可。 集群部署，根据情况每个实例自增即可。
         */
        private Long dataCenterId = 0L;
    }

}

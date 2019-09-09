package com.cheese.amapapi.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Icemap
 * @date 2019-09-09 10:48
 */
@ConfigurationProperties(prefix = "amap.api")
public class AMapAPIConf {
    private SnowFlakeConf snowflake;
    private String key;

    public SnowFlakeConf getSnowflake() {
        if (this.snowflake == null) {
            this.snowflake = new SnowFlakeConf();
            this.snowflake.setDataCenterId(0L);
            this.snowflake.setMachineId(0L);
        }
        return snowflake;
    }

    public void setSnowflake(SnowFlakeConf snowflake) {
        this.snowflake = snowflake;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static class SnowFlakeConf {
        private Long dataCenterId;
        private Long machineId;

        public Long getDataCenterId() {
            return dataCenterId;
        }

        public void setDataCenterId(Long dataCenterId) {
            this.dataCenterId = dataCenterId;
        }

        public Long getMachineId() {
            return machineId;
        }

        public void setMachineId(Long machineId) {
            this.machineId = machineId;
        }
    }
}

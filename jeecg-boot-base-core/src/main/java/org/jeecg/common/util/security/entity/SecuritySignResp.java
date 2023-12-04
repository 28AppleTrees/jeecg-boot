package org.jeecg.common.util.security.entity;

import lombok.Data;

/**
 * @Description: SecuritySignResp
 * @Author: wangpengkai
 */
@Data
public class SecuritySignResp {
    private String data;
    private String signData;
    private String aesKey;
}

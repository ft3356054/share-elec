package com.sgcc.uap;

import org.springframework.core.env.MapPropertySource;

import java.util.Date;
import java.util.Map;

/**
 * Created by yizhan on 2018/3/26.
 */
public class EDASConfigPropertySource extends MapPropertySource {

    private final String dataId;

    private final Date timestamp;


    EDASConfigPropertySource(String dataId, Map<String,Object> source, Date timestamp){
        super(dataId,source);
        this.dataId = dataId;
        this.timestamp = timestamp;
    }

    public String getDataId() {
        return dataId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

package com.tango.microdb.domain;

import java.util.Date;

public class Record {
    
    private String id;
    private String info;
    private Date createTime;
    private String source;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    
}

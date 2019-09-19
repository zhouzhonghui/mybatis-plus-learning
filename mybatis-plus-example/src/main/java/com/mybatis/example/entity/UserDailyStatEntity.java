package com.mybatis.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.ResultMap;

import java.io.Serializable;

@Data
@TableName(value = "user_daily_stat")
public class UserDailyStatEntity implements Serializable {
    private static final long serialVersionUID = -4131090338498345784L;
    private int id;
    private String registerUsers;
    private String activeUsers;
    private String chnl;
    private String statTime;
}

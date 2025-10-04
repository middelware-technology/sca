package com.example.beans.commons;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class PageBean {

    @TableField(exist = false)
    private Long page=1L;

    @TableField(exist = false)
    private long limit=5L;
}

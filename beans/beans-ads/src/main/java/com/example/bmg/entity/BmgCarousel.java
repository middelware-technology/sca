package com.example.bmg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 轮播图表
 * </p>
 *
 * @author CW
 * @since 2025-10-04
 */
@Getter
@Setter
@ToString
@TableName("bmg_carousel")
public class BmgCarousel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 首页轮播图主键id
     */
    @TableId(value = "carousel_id", type = IdType.AUTO)
    private Integer carouselId;

    /**
     * 轮播图
     */
    private String carouselUrl;

    /**
     * 点击后的跳转地址(默认不跳转)
     */
    private String redirectUrl;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer carouselRank;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Byte isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改者id
     */
    private Integer updateUser;
}

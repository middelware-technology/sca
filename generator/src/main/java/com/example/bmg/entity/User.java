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
 * 用户表
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Getter
@Setter
@ToString
@TableName("bmg_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 登陆名称(默认为手机号)
     */
    private String loginName;

    /**
     * MD5加密后的密码
     */
    private String passwordMd5;

    /**
     * 个性签名
     */
    private String introduceSign;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 注销标识字段(0-正常 1-已注销)
     */
    private Byte isDeleted;

    /**
     * 锁定标识字段(0-未锁定 1-已锁定)
     */
    private Byte lockedFlag;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;
}

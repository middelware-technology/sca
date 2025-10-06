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
 * 订单详情表
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Getter
@Setter
@ToString
@TableName("bmg_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单关联购物项主键id
     */
    @TableId(value = "order_item_id", type = IdType.AUTO)
    private Long orderItemId;

    /**
     * 订单主键id
     */
    private Long orderId;

    /**
     * 关联商品id
     */
    private Long goodsId;

    /**
     * 下单时商品的名称(订单快照)
     */
    private String goodsName;

    /**
     * 下单时商品的主图(订单快照)
     */
    private String goodsCoverImg;

    /**
     * 下单时商品的价格(订单快照)
     */
    private Integer sellingPrice;

    /**
     * 数量(订单快照)
     */
    private Integer goodsCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}

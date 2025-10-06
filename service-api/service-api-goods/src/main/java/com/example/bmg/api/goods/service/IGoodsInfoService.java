package com.example.bmg.api.goods.service;

import com.example.beans.goods.GoodsInfo;
import com.example.bmg.utils.PageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <p>
 * 商品详情表 服务类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Tag(name="商品详情API")
public interface IGoodsInfoService  {

    /**
     * 查询所有的商品
     * @return List<GoodsInfo>
     */
    @Operation(summary = "查询所有的商品")
    @GetMapping("/getGoodsList")
    List<GoodsInfo> getGoodsList();

    /**
     * 分页查询商品
     * @return PageUtils<GoodsInfo>
     */
    @Operation(summary = "分页查询商品")
    @PostMapping("/getGoodsPage")
    PageUtils<GoodsInfo> getGoodsPage(GoodsInfo goodsInfo);

    /**
     * 根据商品ID查询商品
     * @param goodsId 商品ID
     * @return GoodsInfo
     */
    @Operation(summary = "根据商品ID查询商品")
    @GetMapping("/getGoodsById/{goodsId}")
    GoodsInfo getGoodsById(@PathVariable(name = "goodsId") Long goodsId);
}

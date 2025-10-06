package com.example.bmg.api.goods.service;

import com.example.beans.goods.GoodsCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 商品类别表 服务类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Tag(name = "商品目录API")
public interface IGoodsCategoryService {

    /**
     * 查询商品目录
     * @return List<GoodsCategory>
     */
    @Operation(summary = "查询商品目录")
    @GetMapping("/getGoodsCategoryList")
    List<GoodsCategory> getGoodsCategoryList();

    /**
     * 查询指定商品目录的下一层级所有目录
     */
    @Operation(summary = "查询指定商品目录的下一层级所有目录")
    @GetMapping("/getGoodsCategoryListByParentId/{parentId}")
    List<GoodsCategory> getGoodsCategoryListByParentId(@PathVariable(name = "parentId") Long parentId);
}

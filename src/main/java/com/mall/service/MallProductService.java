package com.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.entity.MallProduct;

import java.util.List;

/**
 * (MallProduct)表服务接口
 *
 * @author Mr.Z
 * @since 2023-03-15 14:15:38
 */
public interface MallProductService extends IService<MallProduct> {

    List<MallProduct> selectFlashSale();

    List<MallProduct> selectRecommend();

    List<MallProduct> selectHotSellingArea();

    List<MallProduct> mallProductList(Integer pageNum);

    MallProduct pollIndividualItems(String productId);

}


package com.mall.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.entity.MallProduct;
import com.mall.mapper.MallProductMapper;
import com.mall.service.MallProductService;
import com.mall.util.RandomNumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (MallProduct)表服务实现类
 *
 * @author Mr.Z
 * @since 2023-03-15 14:15:38
 */
@Service("mallProductService")
public class MallProductServiceImpl extends ServiceImpl<MallProductMapper, MallProduct> implements MallProductService {
    @Resource
    private MallProductMapper mallProductMapper;

    @Override
    public List<MallProduct> selectFlashSale() {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mall_natureOfGoods", "限时抢购");
        List<MallProduct> mallProducts = mallProductMapper.selectProduct(queryWrapper);
        return mallProducts;
    }

    @Override
    public List<MallProduct> selectRecommend() {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mall_natureOfGoods", "卖场推荐");
        Long aLong = mallProductMapper.selectCount(queryWrapper);
        int i = RandomUtil.randomInt(1, Math.toIntExact(aLong));
        Page<MallProduct> page = new Page<>(i, aLong - 4);
        List<MallProduct> list1 = mallProductMapper.selectProduct(page, queryWrapper);
        List<Integer> number = RandomNumberUtils.Number(1, 10, 4);
        List<MallProduct> list = new ArrayList<>();
        number.forEach(s -> list.add(list1.get(s)));
        return list;
    }

    @Override
    public List<MallProduct> selectHotSellingArea() {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mall_natureOfGoods", "热卖区");
        Long aLong = mallProductMapper.selectCount(queryWrapper);
        int i = RandomUtil.randomInt(1, Math.toIntExact(aLong - 10));
        Page<MallProduct> page = new Page<>(i, 12);
        List<MallProduct> mallProductVos = mallProductMapper.selectProduct(page, queryWrapper);
        List<Integer> number = RandomNumberUtils.Number(1, 11, 6);
        List<MallProduct> list = new ArrayList<>();
        number.forEach(s -> list.add(mallProductVos.get(s)));
        return list;
    }

    /**
     * 商城产品列表
     *
     * @param pageNum 页面num
     * @return {@link List}<{@link MallProduct}>
     */
    @Override
    public List<MallProduct> mallProductList(Integer pageNum) {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        Page<MallProduct> page = new Page<>(pageNum, 28);
        List<MallProduct> list = mallProductMapper.selectProduct(page, queryWrapper);
        return list;
    }

    /**
     * 调查单个商品
     *
     * @param productId 产品id
     * @return {@link List}<{@link MallProduct}>
     */
    @Override
    public MallProduct pollIndividualItems(String productId) {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mall_product_id", productId);
        MallProduct mallProduct = mallProductMapper.selectProductOne(queryWrapper);
        return mallProduct;
    }
}


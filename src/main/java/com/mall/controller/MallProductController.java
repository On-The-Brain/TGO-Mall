package com.mall.controller;

import com.mall.entity.MallProduct;
import com.mall.service.MallProductService;
import com.mall.util.EnumCode;
import com.mall.util.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MallProduct)表控制层
 *
 * @author Mr.Z
 * @since 2023-03-15 14:16:26
 */
@RestController
@RequestMapping("mallProduct")
public class MallProductController {
    /**
     * 服务对象
     */

    @Resource
    private MallProductService mallProductService;

    @RequestMapping("start")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/mallProduct/message");
        return modelAndView;
    }

    /**
     * 选择所有
     *
     * @return 所有数据
     */
    @GetMapping("message")
    public ModelAndView selectAll() {
        List<MallProduct> mallProducts = mallProductService.selectFlashSale();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("frontDesk/index_fe");
        modelAndView.addObject("mallProductVos", mallProducts);
        return modelAndView;
    }

    @GetMapping("message/{scene}")
    public ResponseData<Object> storeRecommendation(@PathVariable Integer scene) {
        List<MallProduct> list = null;
        switch (scene) {
            case 1:
                list = mallProductService.selectRecommend();
                break;
            case 2:
                list = mallProductService.selectHotSellingArea();
                break;
        }
        return ResponseData.generator(EnumCode.SUCCESS.getCode(), EnumCode.SUCCESS.getMessage(), list);
    }


    @GetMapping("messages/{pageNum}")
    public ResponseData<Object> mallProductList(@PathVariable Integer pageNum) {
        List<MallProduct> mallProducts = mallProductService.mallProductList(pageNum);
        return ResponseData.generator(EnumCode.SUCCESS.getCode(), EnumCode.SUCCESS.getMessage(), mallProducts);
    }


    @GetMapping("messageOne/{productId}")
    public ModelAndView mallProductOne(@PathVariable String productId) {
        ModelAndView modelAndView = new ModelAndView();
        MallProduct mallProduct = mallProductService.pollIndividualItems(productId);
        modelAndView.addObject(ResponseData.generator(EnumCode.SUCCESS.getCode(), EnumCode.SUCCESS.getMessage(), mallProduct));
        modelAndView.setViewName("frontDesk/page");
        return modelAndView;
    }
}


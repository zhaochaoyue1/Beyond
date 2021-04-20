package com.example.Ioc.service.impl;

import com.example.Ioc.service.MyAutowire;
import com.example.Ioc.service.SkuService;

/**
 * @description: ProudctServiceImpl
 * @date: 2021/4/20 下午7:47
 * @author: zcy
 * @version: 1.0
 */
public class ProductServiceImpl {
    @MyAutowire
    private SkuServiceImpl skuServiceImpl;
    private SkuService skuService;

    public SkuServiceImpl getSkuServiceImpl() {
        return skuServiceImpl;
    }

    public SkuService getSkuService() {
        return skuService;
    }

    public void setSkuService(SkuService skuService) {
        this.skuService = skuService;
    }
}

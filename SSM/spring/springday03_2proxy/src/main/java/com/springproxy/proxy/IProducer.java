package com.springproxy.proxy;

/**
 * 多生产厂家的要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
     void saleProducer(float money);

    /**
     * 售后
     * @param money
     */
    void afterService(float money);
}

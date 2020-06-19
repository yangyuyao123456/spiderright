package com.ks.spider.entity;

import lombok.Data;

/**
 * @author by hj
 * @Date 2020/5/10 18:13
 * @Description :商品信息封装类
 */
@Data
public class GoodsInfo {
    private Integer id;

    private String goodsName;

    private String url;

    private String pic;

    private Long  sku;
}

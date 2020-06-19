package com.ks.spider.service;

import com.ks.spider.entity.GoodsInfo;
import com.ks.spider.vo.GoodsInfoVo;

import java.util.List;

/**
 * @author by hj
 * @Date 2020/5/10 18:18
 * @Description :商品信息
 */
public interface GoodsInfoService {
    /**
     * 添加商品信息
     * @param
     * @param
     * @param
     * @return
     */
    Integer addGoodsInfo( GoodsInfo goodsInfo);

    /**
     * 模糊查询商品名称信息
     * @param vo
     * @return
     */
    List<GoodsInfo> getGoodsInfoByName(GoodsInfoVo vo);
}

package com.ks.spider.mapper;

import com.ks.spider.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author by hj
 * @Date 2020/5/10 18:20
 * @Description : 京东爬虫数据查询接口
 */
@Mapper
public interface GoodsInfoMapper {

    /**
     * 添加商品信息
     * @param goodsInfo
     * @return
     */
    Integer addGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 模糊查询商品名称信息
     * @param name
     * @param pageSize
     * @param offset
     * @return
     */
    List<GoodsInfo> getGoodsInfoByName(@Param("name") String name,@Param("pageSize") int pageSize,@Param("offset") int offset);
}

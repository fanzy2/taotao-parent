package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import com.taotao.pojo.TbItemExample.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanzy on 2017/7/18.
 */

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    /**
     * 商品管理service
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(long itemId) {
        //itemMapper.selectByPrimaryKey(itemId);
        TbItemExample tbItemExample =new TbItemExample();
        //添加查询条件
        Criteria criteria=tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=itemMapper.selectByExample(tbItemExample);
        if (list!=null&&list.size()>0){
            return list.get(0);

        }
        return null;
    }
    /**
     * 商品列表查询
     * <p>Title: getItemList</p>
     * <p>Description: </p>
     * @param page
     * @param rows
     * @return
     */
    @Override
    public  EUDataGridResult getItemList(int page,int rows){
        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

}

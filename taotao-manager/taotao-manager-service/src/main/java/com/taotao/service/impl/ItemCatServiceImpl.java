package com.taotao.service.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanzy on 2017/7/20.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EUTreeNode> getItemCatList(Long parentId){
        TbItemCatExample example =new TbItemCatExample();
        //设置查询条件
        Criteria criteria=example.createCriteria();
        //根据parentId查询子节点
        criteria.andParentIdEqualTo(parentId);
        //返回子节点列表
        List<EUTreeNode> resultList=new ArrayList<EUTreeNode>();
        List<TbItemCat> list=tbItemCatMapper.selectByExample(example);
        for (TbItemCat tbItemCat :list){
            EUTreeNode node=new EUTreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        return resultList;
    }
}

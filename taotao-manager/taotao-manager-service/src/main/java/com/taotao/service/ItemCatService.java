package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;

import java.util.List;

/**
 * Created by fanzy on 2017/7/20.
 */
public interface ItemCatService {
    public List<EUTreeNode> getItemCatList(Long parentId);


}

package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import org.springframework.stereotype.Service;

/**
 * Created by fanzy on 2017/7/18.
 */
public interface ItemService {
    TbItem getItemById(long itemId);

    EUDataGridResult getItemList(int page,int rows);


}

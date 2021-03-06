package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;


import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanzy on 2017/7/18.
 */

/**
 * 商品管理controller
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(@RequestParam(defaultValue="1")Integer  page,@RequestParam(defaultValue="30")Integer rows) {
        EUDataGridResult result = itemService.getItemList(page,rows);
        return result;
    }
}

package com.taotao.controller;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * Created by fanzy on 2017/7/20.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> categoryList(@RequestParam(value ="id",defaultValue = "0")Long parentId)throws Exception{
        List<EUTreeNode> resultList=itemCatService.getItemCatList(parentId);
        return resultList;
    }

}

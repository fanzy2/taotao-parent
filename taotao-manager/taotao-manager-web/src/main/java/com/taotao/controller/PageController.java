package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fanzy on 2017/7/19.
 */
@Controller
public class PageController {
    /**
     * 页面的跳转
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * 展示其他界面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}

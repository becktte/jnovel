package com.umbrella.jnovel.web.controller;

import com.umbrella.jnovel.system.novel.model.Novel;
import com.umbrella.jnovel.system.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
@Controller
@RequestMapping("/novel")
public class NovelController {

    @Autowired
    private NovelService novelService;

    @RequestMapping("/queryNovelList")
    @ResponseBody
    public List<Novel> queryNovelList() {
        List<Novel> novels = novelService.queryNovelList();
        return novels;
    }
}

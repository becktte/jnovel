package com.umbrella.jnovel.system.novel.service.impl;

import com.umbrella.jnovel.system.annotation.DataSource;
import com.umbrella.jnovel.system.enums.DataSourceType;
import com.umbrella.jnovel.system.novel.mapper.NovelMapper;
import com.umbrella.jnovel.system.novel.model.Novel;
import com.umbrella.jnovel.system.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    @Override
    @DataSource(DataSourceType.MASTER)
    public List<Novel> queryNovelList() {
        return novelMapper.queryNovelList();
    }
}

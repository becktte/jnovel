package com.umbrella.jnovel.system.novel.mapper;

import com.umbrella.jnovel.system.novel.model.Novel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NovelMapper {
    List<Novel> queryNovelList();
}

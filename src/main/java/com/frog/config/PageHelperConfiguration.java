package com.frog.config;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

/**
 * MyBatis PageHelper 翻页控件配置文件
 * @author Robert.Jiang
 * @date 2019年5月21日 上午11:02:11
 */
public class PageHelperConfiguration {
	private static final Logger log = LogManager.getLogger(PageHelperConfiguration.class);
    @Bean
    public PageHelper pageHelper() {
        log.info("------Register MyBatis PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true"); //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        p.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(p);
        
        return pageHelper;
    }
}

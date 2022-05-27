package com.summer.gmall.mock.db;

import com.summer.gmall.mock.db.service.DimDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Slf4j
public class MockTask {

    @Resource
    DimDayService dimDayService;


    @Value("${mock.dim.before-date}")
    String beforeDate;


    @Value("${mock.dim.after-date}")
    String afterDate;


    @Transactional
    public void mainTask() {
        log.warn("----------------开始生成测试数据----------------");
//        usersService.genUserInfos(100000);

        log.warn("----------------开始生成日期维度的测试数据----------------");
        dimDayService.genDimDays(this.beforeDate, this.afterDate);

    }

}

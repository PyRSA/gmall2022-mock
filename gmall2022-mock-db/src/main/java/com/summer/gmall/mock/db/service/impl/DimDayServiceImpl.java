package com.summer.gmall.mock.db.service.impl;

import com.summer.gmall.mock.db.bean.DimDay;
import com.summer.gmall.mock.db.mapper.DimDayMapper;
import com.summer.gmall.mock.db.service.DimDayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.gmall.mock.db.util.DimDayDto;
import com.summer.gmall.mock.db.util.WeekdayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 日-时间维表 服务实现类
 * </p>
 *
 * @author zsd
 * @since 2022-03-10
 */
@Service
@Slf4j
public class DimDayServiceImpl extends ServiceImpl<DimDayMapper, DimDay> implements DimDayService {


    /**
     * 产生日期维度表数据
     */
    @Override
    public void genDimDays(String beforeDate, String afterDate) {
        List<DimDay> dimDaysList = new ArrayList<>();
        WeekdayUtil dateUtils = new WeekdayUtil();
        List<DimDayDto> dimDayDtos = dateUtils.compareWeekday(beforeDate, afterDate, 10);
        for (DimDayDto dimDayDto : dimDayDtos) {
            DimDay dimDay = new DimDay();
            BeanUtils.copyProperties(dimDayDto, dimDay);
            dimDaysList.add(dimDay);
        }
        saveBatch(dimDaysList, 10000);
//        for (DimDay dimDay : dimDaysList) {
//            System.out.println(dimDay);
//        }
        log.warn("共生成{}条数据", dimDaysList.size());
    }
}

package com.summer.gmall.mock.db.service;

import com.summer.gmall.mock.db.bean.DimDay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 日-时间维表 服务类
 * </p>
 *
 * @author zsd
 * @since 2022-03-10
 */
public interface DimDayService extends IService<DimDay> {

    void genDimDays(String beforeDate, String afterDate);
}

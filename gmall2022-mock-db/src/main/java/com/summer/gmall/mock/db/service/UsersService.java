package com.summer.gmall.mock.db.service;

import com.summer.gmall.mock.db.bean.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zsd
 * @since 2022-03-03
 */
public interface UsersService extends IService<Users> {

    void genUserInfos(Integer count);

}

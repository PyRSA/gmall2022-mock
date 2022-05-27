package com.summer.gmall.mock.db.service.impl;

import com.summer.gmall.mock.db.util.*;
import com.summer.gmall.mock.db.bean.Users;
import com.summer.gmall.mock.db.mapper.UsersMapper;
import com.summer.gmall.mock.db.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zsd
 * @since 2022-03-03
 */
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {


    @Override
    public void genUserInfos(Integer count) {

        Date date = new Date();

        List<Users> userInfoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            userInfoList.add(initUserInfo(date));
        }

        saveBatch(userInfoList, 10000);
        log.warn("共生成{}名用户", userInfoList.size());
    }

    private Users initUserInfo(Date date) {
        Users users = new Users();
        String email = RandomEmail.getEmail(6, 12);
        String nickName = email.split("@")[0];
        users.setSex(Integer.parseInt(new RandomOptionGroup(new RanOpt("1", 50), new RanOpt("0", 50)).getRandStringValue()));
        String lastName = RandomName.insideLastName(users.getSex().toString());

        String[] suffs = "赵,钱,孙,李,张,王,李,刘,公孙,欧阳,邓,刘,吕,周,季,于".split(",");
        String suff = suffs[(int) (Math.random() * suffs.length)];
        users.setUsername(suff + lastName);
        users.setNickName(nickName);
        users.setEmail(email);
        String[] jobs = "ios开发,java开发,python开发,前端开发,大数据开发,算法,运维人员,测试人员,前台,架构师,销售,行政人员".split(",");
        users.setBirthday(DateUtils.addMonths(date, -1 * RandomNum.getRandInt(15, 55) * 12));
        users.setPhone("13" + RandomNumString.getRandNumString(1, 9, 9, ""));
        String job = jobs[(int) (Math.random() * jobs.length)];
        users.setJob(job);
        //密码加密器
        users.setPassword(MD5Utils.md5Password(email));
        return users;
    }
}

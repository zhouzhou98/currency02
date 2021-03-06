package com.high.concurrency.currency02.service.impl;

import com.high.concurrency.currency02.domain.User;
import com.high.concurrency.currency02.mapper.UserMapper;
import com.high.concurrency.currency02.service.IUserService;
import com.high.concurrency.currency02.util.ExcelUtil;
import com.high.concurrency.currency02.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String exportData() {
        // 获取可用的线程数
        final int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(nThreads << 1);
        int pageSize = PageUtil.pageSize;
        // 获取数据总量
        Integer count = userMapper.getCount();
        // 获取总页数
        int totalPageCount= PageUtil.getTotalPageCount(count);
        // 开始统计时间
        long start=System.currentTimeMillis();
        int maxId = 0;
        for(int currentPageNum = 0; currentPageNum < totalPageCount; currentPageNum++) {
            List<User> userList = userMapper.selectPage(maxId, pageSize);
            maxId = userList.get(userList.size() - 1).getId();
            int finalCurrentPageNum = currentPageNum;

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    ExcelUtil.createExcel(finalCurrentPageNum, userList);
                    if(finalCurrentPageNum == (totalPageCount-1)){
                        System.out.println("  export data to excel, it  has spent " +(System.currentTimeMillis()-start)+"  ms");
                    }
                }
            };
            pool.execute(run);
        }
        return "ok";
    }
}

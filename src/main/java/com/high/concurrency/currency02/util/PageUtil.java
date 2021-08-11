package com.high.concurrency.currency02.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtil {
    public static final int pageSize = 10000;
    private int currentPageNum;
    private int lastPageNum;
    private int totalRecordCount;

    /**
     * 获取总页数
     * @param totalRecordCount 所有的记录数
     * @return 总页数
     */
    public static int getTotalPageCount(int totalRecordCount) {
        if (totalRecordCount == 0) {
            return 0;
        }

        int lastPageCount = totalRecordCount % pageSize;
        int totalPageCount;
        if (lastPageCount < pageSize && lastPageCount > 0) {
            totalPageCount = totalRecordCount / pageSize + 1;
        } else {
            totalPageCount = totalRecordCount / pageSize;
        }
        return totalPageCount;
    }
}

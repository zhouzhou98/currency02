package com.high.concurrency.currency02.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户测试表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String name;

    private Date createdtime;

    private Date updatedtime;
}
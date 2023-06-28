package com.yang.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author: CY.Ma
 * @date: 2023/6/28 10:09
 * @description:
 *  Lazy单例Bean延迟到使用时才进行创建(该注解仅针对与单例对象)，后序再使用时不会再创建
 *  多例对象都是在使用时创建
 */
@Service
@Lazy
public class LazyUserService {

    public LazyUserService() {
        System.out.println("LazyUserService创建了!");
    }

    public void save() {
        System.out.println("保存了懒加载用户!");
    }
}

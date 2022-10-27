package com.itdou.service;

import com.itdou.domain.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PersonService {

    /**
     * 保存
     */
    boolean save(Person person);

    /**
     * 修改
     */
    boolean update(Person person);

    /**
     * 按id删除
     */
    boolean delete(int id);

    /**
     * 查询全部
     */
    List<Person> getAll();
}

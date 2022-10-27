package com.itdou.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itdou.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {
}

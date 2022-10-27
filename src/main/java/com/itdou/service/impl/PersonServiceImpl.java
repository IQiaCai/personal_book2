package com.itdou.service.impl;

import com.itdou.dao.PersonDao;
import com.itdou.domain.Person;
import com.itdou.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public boolean save(Person person) {
        return personDao.insert(person)>0;
    }

    @Override
    public boolean update(Person person) {
        return personDao.updateById(person)>0;
    }

    @Override
    public boolean delete(int id) {
        return personDao.deleteById(id)>0;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = personDao.selectList(null);
        return persons;
    }
}

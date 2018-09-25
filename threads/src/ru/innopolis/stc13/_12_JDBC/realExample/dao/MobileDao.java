package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

public interface MobileDao {
    boolean add(Mobile mobile);
    Mobile get(Integer id);
    boolean updateById(Mobile mobile);
    boolean deleteById(Integer id);
}

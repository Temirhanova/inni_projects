package ru.innopolis.stc13._12_JDBC.realExample;

import ru.innopolis.stc13._12_JDBC.realExample.dao.MobileDao;
import ru.innopolis.stc13._12_JDBC.realExample.dao.MobileDaoJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

public class Main {
    public static void main(String[] args) {
        Mobile mobile = new Mobile(0,"Iphone 2", 25000F, 5);
        MobileDao mobileDao = new MobileDaoJdbcImpl();
        mobileDao.add(mobile);
//        mobileDao.deleteById(7);
    }
}

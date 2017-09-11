package com.example.a02.myormlitetest;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.List;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 * 功能：
 * 示范：
 * 作者：常兴
 * 创建时间：2017/9/11
 * 修改内容：
 * 最后修改时间：
 */

@RunWith(AndroidJUnit4.class)
public class OrmLiteTest {
    DaoManager daoManager;
    Dao<User,Integer> userDao;


    @Before
    public void setUp(){
        daoManager = new DaoManager(getContext());
        try {
            userDao = daoManager.getUserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testAddUser(){
        try {
            userDao.create(new User("张三","士大夫"));
            userDao.create(new User("李四","告诉对方"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testQuery(){
        try {
            List<User> list = userDao.queryForAll();
            Log.i("userlist",list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

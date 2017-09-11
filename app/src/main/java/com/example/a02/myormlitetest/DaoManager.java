package com.example.a02.myormlitetest;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * 功能：
 * 示范：
 * 作者：常兴
 * 创建时间：2017/9/11
 * 修改内容：
 * 最后修改时间：
 */

public class DaoManager {
    private MySqliteHelper dbHelper;
    private Dao<User,Integer> userDao;

    public DaoManager(Context context){
        dbHelper = MySqliteHelper.getDbHelper(context);
    }

    public Dao<User,Integer> getUserDao() throws SQLException {
        if(userDao == null){
            userDao = dbHelper.getDao(User.class);
        }
        return userDao;
    }

    public void close(){
        dbHelper.close();
        userDao = null;
    }



}

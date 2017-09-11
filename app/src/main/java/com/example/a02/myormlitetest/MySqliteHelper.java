package com.example.a02.myormlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by 红木街02 on 2017/9/11.
 */

public class MySqliteHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASENAME = "mysqlite";
    public static final int DATABASE_VERSION = 1;
    private static MySqliteHelper instance;

    private MySqliteHelper(Context context){
        super(context,DATABASENAME,null,DATABASE_VERSION);
    }

    public static MySqliteHelper getDbHelper(Context context){
        if(instance == null){
            synchronized (MySqliteHelper.class){
                if(instance == null){
                    instance = new MySqliteHelper(context);
                }
            }
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.clearTable(connectionSource,User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,User.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}

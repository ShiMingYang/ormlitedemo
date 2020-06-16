package com.sqw.ormdemosmy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lsj on 2015/11/9.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {


    private static final String TABLE_NAME = "person.db";

    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 8);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Person.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        if(oldVersion < 7){//暂不说明为何要这么判断 (此判断是为了迁移数据升级库表增加字段 数据不丢失的操作)
            DatabaseUtil.upgradeTable(db,connectionSource,Person.class,DatabaseUtil.OPERATION_TYPE.ADD);
        }
        onCreate(db,connectionSource);
    }

    private static DatabaseHelper instance;

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized DatabaseHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null){
                    instance=new DatabaseHelper(context);
                }
            }
        }
        return instance;
    }

    public synchronized Dao getDao(Class clazz)throws SQLException{
        Dao dao=null;
        String className=clazz.getSimpleName();
        if(daos.containsKey(className)){
            dao=daos.get(className);
        }
        if(dao==null){
            dao=super.getDao(clazz);
            daos.put(className,dao);
        }
        return dao;
    }

    /**
     * 释放资源
     */

    @Override
    public void close() {
        super.close();

        for(String key:daos.keySet()){
            Dao dao=daos.get(key);
            dao=null;
        }
    }
}
package com.sqw.ormdemosmy;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsj on 2015/11/9.
 */
class UserDao1 {

    private Context context;
    private Dao<Perppp, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao1(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(Perppp.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDao1() {

    }

    /**
     * 添加一个用户
     * @param user
     */

    public void add(ArrayList<Perppp> user) {
//        //事务操作
//        TransactionManager.callInTransaction(helper.getConnectionSource(), new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                return null;
//            }
//        });
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Perppp get(int id) {
        try {
            return userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Perppp> query(){
        List<Perppp> fpList = null;
        try {
            fpList =userDaoOpe.queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fpList;
    }

    /**
     * 清空所有记录信息
     *
     * @return
     */
    public void deleteAll() {
        try {
            userDaoOpe.queryRaw("DELETE\n" +
                    "FROM\n" +
                    "\tppppp");
            userDaoOpe.queryRaw("UPDATE sqlite_sequence\n" +
                    "SET seq = 0\n" +
                    "WHERE\n" +
                    "\tname = 'ppppp'");
        } catch (SQLException e) {
        }
    }
}

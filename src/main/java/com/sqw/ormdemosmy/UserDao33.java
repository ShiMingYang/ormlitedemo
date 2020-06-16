package com.sqw.ormdemosmy;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsj on 2015/11/9.
 */
class UserDao33 {

    private Context context;
    private Dao<Person3333, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao33(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(Person3333.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDao33() {

    }

    /**
     * 添加一个用户
     * @param user
     */

    public void add(ArrayList<Person3333> user) {
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

    public Person3333 get(int id) {
        try {
            return userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person3333> query(){
        List<Person3333> fpList = null;
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

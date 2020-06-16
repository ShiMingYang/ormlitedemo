package com.sqw.ormdemosmy;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsj on 2015/11/9.
 */
class UserDao {

    private Context context;
    private Dao<Person, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(Person.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDao() {

    }

    /**
     * 添加一个用户
     * @param user
     */

    public void add(ArrayList<Person> user) {

        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * 查询全部数据
     * @return
     */

    public List<Person> query(){
        List<Person> fpList = null;
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
                    "\tpersons");
            userDaoOpe.queryRaw("UPDATE sqlite_sequence\n" +
                    "SET seq = 0\n" +
                    "WHERE\n" +
                    "\tname = 'persons'");
        } catch (SQLException e) {
        }
    }
}

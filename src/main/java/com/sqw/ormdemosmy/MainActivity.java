package com.sqw.ormdemosmy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 插入
     */
    private Button mBtn1;
    /**
     * 删除
     */
    private Button mBtn2;
    /**
     * 修改
     */
    private Button mBtn3;
    /**
     * 查询
     */
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    /**
     * Hello World!
     */
    private TextView mTv;
    private Person person;
    private UserDao dao;
    private UserDao1 dao1;
    private UserDao33 dao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dao = new UserDao(this);//初始化第一张表
        dao1 = new UserDao1(this);//初始化第二张表
        dao3 = new UserDao33(this);//初始化第三张表

    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn5 = (Button) findViewById(R.id.btn5);
        mBtn4.setOnClickListener(this);;
        mBtn6 = (Button) findViewById(R.id.btn6);
        mBtn6.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mBtn5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1://添加数据
                person = new Person();
                ArrayList<Person> people = new ArrayList<>();
//                people.add(new Person("smy44444","1234444")); //默认两个字段信息,升级库表增加下面两个字段
                people.add(new Person("smy44444","1234444","334444","nan344444"));
                dao.add(people);

                break;
            case R.id.btn2:
                ArrayList<Person3333> people33 = new ArrayList<>();
                people33.add(new Person3333("smy","123"));
                dao3.add(people33);

                break;
            case R.id.btn3://删除,清空表
                dao.deleteAll();
                break;
            case R.id.btn4://查询所有数据
                List<Person> list = dao.query();

                mTv.setText(list.toString());
                break;
            case R.id.btn5:
//                List<Perppp> list1 = dao1.query();
//
//                mTv.setText(list1.toString());
                break;
            case R.id.btn6://查询所有
//                List<Person3333> list3 = dao3.query();
//
//                mTv.setText(list3.toString());
                break;
        }
    }
}

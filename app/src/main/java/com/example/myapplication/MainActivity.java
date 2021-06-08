package com.example.myapplication;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<ItemBean> list = new ArrayList<>();

        ItemBean itemBean1 = new ItemBean(R.drawable.bj, "拜见女皇陛下", "小学生于1996年开始的战斗。");
        ItemBean itemBean2 = new ItemBean(R.drawable.dn, "端脑", "《端脑》简介：端脑是什么？如果从字面意思来讲，端脑就是由左右两个大脑组成的生物器官。在这部故事里，它用来描述由对冲宇宙构成的庞大系统，我们叫它端脑宇宙，故事从一个个未知的杀人案开始，逐步揭开掩藏在整个宇宙中的巨大秘密，从骇人听闻的阴谋，到银河系战争，从反人类的背叛到伟大的牺牲，人类从来未曾...。");
        ItemBean itemBean3 = new ItemBean(R.drawable.zh, "镇魂街", "镇魂街，此乃吸纳亡灵镇压恶灵之地。这是一个人灵共存的世界，但不是每个人都能进入镇魂街，只有拥有守护灵的寄灵人才可进入。夏铃原本是一名普通的大学实习生，但一次偶然导致她的人生从此不再平凡。。。在这个充满恶灵的世界，你能与你的守护灵携手生存下去吗？官博@镇魂街：http://weibo.com/u/5195985855 镇...。");

        list.add(itemBean1);
        list.add(itemBean2);
        list.add(itemBean3);
        list.add(itemBean1);
        list.add(itemBean2);
        list.add(itemBean3);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        MyReAdapter adapter = new MyReAdapter(list);


        adapter.setOnItemClickListener(this, new OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                if (position < 3)
                    intent = new Intent(MainActivity.this, DetailActivity2.class);
                else
                    intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("bean", list.get(position));
                // create the transition animation - the images in the layouts
                // of both activities are defined with android:transitionName="robot"

                view.setTransitionName("aaa");

                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, view, "aaa");
                // start the new activity
                startActivity(intent, options.toBundle());

            }


        });


        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }
}

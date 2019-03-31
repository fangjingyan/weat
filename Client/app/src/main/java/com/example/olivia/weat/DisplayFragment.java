package com.example.olivia.weat;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private View view;
    public RecyclerView mCollectRecyclerView;
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();
    private CollectRecycleAdapter mCollectRecyclerAdapter;
    private String[] mParam1;

    public DisplayFragment() {
        // Required empty public constructor
    }
    public static DisplayFragment newInstance(String[] param1) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_display, container, false);
        //String[] streets = getArguments().getStringArray(ARG_PARAM1);
        //String str = String.join(",", streets);
        //TextView textview = (TextView) view.findViewById(R.id.display_title);
        //textview.setText(str);
        initRecyclerView();
        initData();
        return view;
    }

    private void initData() {
        String[] streets = getArguments().getStringArray(ARG_PARAM1);
        for (int i=0;i<streets.length;i++){
            if (streets[i].length()>1){
                GoodsEntity goodsEntity=new GoodsEntity();
                goodsEntity.setGoodsName(streets[i]);
                //goodsEntity.setGoodsPrice("100"+i);
                goodsEntityList.add(goodsEntity);
            }
        }
    }

    private void initRecyclerView() {
        //获取RecyclerView
        mCollectRecyclerView=(RecyclerView)view.findViewById(R.id.collect_recyclerView);
        //创建adapter
        mCollectRecyclerAdapter = new CollectRecycleAdapter(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        mCollectRecyclerAdapter.setOnItemClickListener(new CollectRecycleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(),"Google will tell you how to cook it!",Toast.LENGTH_SHORT).show();
            }
        });
    }


}

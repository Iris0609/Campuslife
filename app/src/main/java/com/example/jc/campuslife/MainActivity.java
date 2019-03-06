package com.example.jc.campuslife;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;

import layout.DiscoveryFragment;
import layout.FavouriteFragment;
import layout.MainFragment;
import layout.SettingFragment;

public class MainActivity extends Activity implements View.OnClickListener{

    //   MapView mMapView = null;

    private Button map_btn;
    private Button discovery_btn;
    private Button favourite_btn;
    private Button setting_btn;
 //   private EditText editText;
 //   private Button search_btn;

    //------------------------------------------------------------
    //主页fragment
    private MainFragment mainFragment;
    //发现活动fragment
    private DiscoveryFragment discoveryFragment;
    //收藏的活动fragment
    private FavouriteFragment favouriteFragment;
    //设定fragment
    private SettingFragment settingFragment;
    //主页布局
    private View mainLayout;
    //发现活动布局
    private View discoveryLayout;
    //我的收藏布局
    private View favouriteLayout;
    //设置布局
    private View settingLayout;
    //各个Tab上的图片
    private ImageView mainImage;
    private ImageView discoveryImage;
    private ImageView favouriteImage;
    private ImageView settingImage;
    //各个Tab上的文字
    private TextView mainText;
    private TextView discoveryText;
    private TextView favouriteText;
    private TextView settingText;
    //用于对fragment进行管理
    private FragmentManager fragmentManager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //-----------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        requestWindowFeature(Window.FEATURE_NO_TITLE);//4.27
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);

    }

    private void initViews() {
        mainLayout=findViewById(R.id.main_layout);
        discoveryLayout=findViewById(R.id.discovery_layout);
        favouriteLayout=findViewById(R.id.favourite_layout);
        settingLayout=findViewById(R.id.setting_layout);

        mainImage=(ImageView)findViewById(R.id.main_image);
        discoveryImage=(ImageView)findViewById(R.id.discovery_image);
        favouriteImage=(ImageView)findViewById(R.id.favourite_image);
        settingImage=(ImageView)findViewById(R.id.setting_image);

        mainText=(TextView)findViewById(R.id.main_text);
        discoveryText=(TextView)findViewById(R.id.discovery_text);
        favouriteText=(TextView)findViewById(R.id.favourite_text);
        settingText=(TextView)findViewById(R.id.setting_text);
        //设置点击响应事件
        mainLayout.setOnClickListener(this);
        discoveryLayout.setOnClickListener(this);
        favouriteLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //点击不同的tab选中不同tab
            case R.id.main_layout:
                setTabSelection(0);
                break;
            case R.id.discovery_layout:
                setTabSelection(1);
                break;
            case R.id.favourite_layout:
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index){
        //每次选中前先清除上次选中的状态
        clearSelection();
        //开启一个Fragment事务
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        //先隐藏所有Fragment，防止有多个Fragment显示在界面上
        hideFragments(transaction);
        switch (index){
            case 0:
                //当点击tab时，改变tab图片和文字颜色
               /*
                mainImage.setImageResource();
                mainText.setTextColor();
                */
                if(mainFragment==null){
                    //若为空，则新建一个
                    mainFragment=new MainFragment();
                    transaction.add(R.id.content, mainFragment);
                }
                else {
                    //若不为空就显示出来
                    transaction.show(mainFragment);
                }
                break;
            case 1:
                //当点击tab时，改变tab图片和文字颜色
               /*
                mainImage.setImageResource();
                mainText.setTextColor();
                */
                if(discoveryFragment==null){
                    discoveryFragment=new DiscoveryFragment();
                    transaction.add(R.id.content,discoveryFragment);
                }
                else {
                    transaction.show(discoveryFragment);
                }
                break;
            case 2:
                //当点击tab时，改变tab图片和文字颜色
               /*
                mainImage.setImageResource();
                mainText.setTextColor();
                */
                if(favouriteFragment==null){
                    favouriteFragment=new FavouriteFragment();
                    transaction.add(R.id.content,favouriteFragment);
                }
                else {
                    transaction.show(favouriteFragment);
                }
                break;
            case 3:
            default:
                //当点击tab时，改变tab图片和文字颜色
               /*
                mainImage.setImageResource();
                mainText.setTextColor();
                */
                if(settingFragment==null){
                    settingFragment=new SettingFragment();
                    transaction.add(R.id.content,settingFragment);
                }
                else {
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }

    //清除所有选中状态
    private void clearSelection(){
        //改变tab样式，如：
        /*
        mainImage.setImageResource();
        mainText.setTextColor();
        */
    }

    //将所有fragment设置为隐藏状态
    private void hideFragments(FragmentTransaction transaction)
    {
        if(mainFragment!=null)
        {
            transaction.hide(mainFragment);
        }
        if(discoveryFragment!=null)
        {
            transaction.hide(discoveryFragment);
        }
        if(favouriteFragment!=null)
        {
            transaction.hide(favouriteFragment);
        }
        if(settingFragment!=null)
        {
            transaction.hide(settingFragment);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}

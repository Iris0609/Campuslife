package com.example.jc.campuslife;

import android.app.Activity;

/**
 * Created by Iris on 2017/4/27.
 */

public class Spinner01Act extends Activity {
  /*  private TextView view;
    private Spinner spinner;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_layout);
        spinner=(Spinner)findViewById(R.id.spinner1);
        view=(TextView)findViewById(R.id.setting_text);
        //可选内容与ArrayAdapter连接起来
        adapter=ArrayAdapter.createFromResource(this,R.array.time_dis,android.R.layout.simple_spinner_item);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerXMLSelectedListener());

        //设置默认值
        spinner.setVisibility(View.VISIBLE);

    }

    /*onItemSelected参数
    第一个参数parent是你当前所操作的Spinner，当某一个Activity中有多个Spinner时，可以根据parent.getId()与R.id.currentSpinner是否相等，来判断是否你当前操作的Spinner，
    一般在onItemSelected方法中，通过switch...case...语句来解决多个Spinner的情况
    第二个参数view,经过我的测试，在同一个Activity的多个Spinner中，无论你操作任何一个Spinner，选中任何一个下拉值，view(或者说view.getId())的值都不变，因此，我们可以不用关心这个view，因为一般不可能用得到。
    第三个参数position，是你选中的某个Spinner中的某个下拉值所在的位置，一般自上而下从0开始。
    第四个参数id，是你选中的某个Spinner中的某个下来值所在的行，一般自上而下从0开始，id的值与第三个参数position的值一直是一样的。
     */
  /*  class SpinnerXMLSelectedListener implements OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view.setText(adapter.getItem(arg2).toString());
            /*
            添加选择不同选项的行为可以用arg2结合switch...case..语句
             */
        }

  /*      public void onNothingSelected(AdapterView<?> arg0) {
            view.setText(adapter.getItem(0).toString());
            /*
            默认排序
             */

 /*       }
    }
}*/

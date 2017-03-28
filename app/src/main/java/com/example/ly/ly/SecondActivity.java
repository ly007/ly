package com.example.ly.ly;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;

    //一天的毫秒数 86400000 = 24*60*60*1000;
    private static final int millisPerDay = 86400000 ;
    //一小时的毫秒数 3600000 = 24*60*60*1000;
    private static final int millisPerHour = 3600000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        try {
            Long range  =  howLong("d","2017-07-05 10:33:03","2017-07-06 11:33:03");
            Log.e("123", "onCreate: 23123123123"+range );
            text.setText(String.valueOf(range));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /*   * 计算时间差 (时间单位,开始时间,结束时间)
       * 调用方法 howLong("h","2007-08-09 10:22:26","2007-08-09 20:21:30") ///9小时56分 返回9小时
       * */
    public static long howLong(String unit,String time1,String time2) throws ParseException
    {
        //时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time1);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time2);
        long ltime = date1.getTime()-date2.getTime()<0 ? date2.getTime()-date1.getTime():date1.getTime()-date2.getTime();
        if(unit.equals("s"))
        {
            return ltime/1000;//返回秒
        }
        else if(unit.equals("m"))
        {
            return ltime/60000;//返回分钟
        }
        else if(unit.equals("h"))
        {
            return ltime/millisPerHour;//返回小时
        }
        else if(unit.equals("d"))
        {
            return ltime/millisPerDay;//返回天数
        }
        else
        {
            return 0;
        }
    }
}

package sysdate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputDate {
    public void getDate(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒SSSミリ秒");
    	System.out.println(sdf.format(new Date()));
    }
}

package com.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Administrator
 */
public class DateTag extends TagSupport {
    private String value;

    @Override
    public int doStartTag() throws JspException {
        // Long.valueOf():将参数转为long的包装类Long
        String vv = "" + value;

        long time = Long.valueOf(vv) * 1000L;
        //Calendar.getInstance() 可以设置特定的年月日和时区等
        Calendar c = Calendar.getInstance();
        //从给定的long值设置日历的当前时间毫秒数
        c.setTimeInMillis(time);
        //设置时间格式 24小时制 HH:mm:ss   12小时制 hh:mm:ss
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //给定String类型变量s 值为根据给定long值设置的时间毫秒数 转换为的 需要的时间格式
        String s = dateformat.format(c.getTime());

        try {
            //pageContext：表示的是一个jsp页面的上下文，而且功能强大，几乎可以操作各种内置对象
            //pageContext.getOut() :该方法返回一个JspWriter类的实例对象，也就是JSP内置对象--out对象，可以往客户端写入输入流。
            pageContext.getOut().write(s);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return super.doStartTag();
    }
    public void setValue(String value) {

        this.value = value;
    }

}


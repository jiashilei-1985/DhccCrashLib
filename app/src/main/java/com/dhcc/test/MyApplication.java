package com.dhcc.test;

import android.app.Application;

import com.dhcc.crashlib.Configuration;
import com.dhcc.crashlib.LogCenter;
import com.dhcc.crashlib.send.email.EmailConfigBean;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initCrash();
    }

    /**
     * 初始化崩溃采集服务
     */
    private void initCrash() {
        EmailConfigBean emailConfigBean = new EmailConfigBean("你的发送邮箱", "你的接收邮箱", "你的发送邮箱密码");
        LogCenter.getLogCenter("com.dhcc.crashLib", Configuration.getInstance().setSendWithNet(true).setEmailConfig(emailConfigBean).setCrashDescription("测试异常~~").setExitWaitTime(5000)).strategy(new TestCollectInfo(), "testInfo").init(this);
    }
}

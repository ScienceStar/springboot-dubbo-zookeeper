package com.customer.notify.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.customer.notify.INotifyService;

/**
 * @ProjectName: springboot_dubbo_zookeeper
 * @Package: com.customer.notify.impl
 * @ClassName: NotifyServiceImpl
 * @Author: LXC
 * @Description: 事件通知实现
 * @Date: 2021/4/16 15:16
 */
@Service
public class NotifyServiceImpl implements INotifyService {
    @Override
    public void oninvoke(String name) {
        System.out.println("=====oninvoke======,  param:"+name);
    }

    @Override
    public void onreturnWithoutParam(String result) {
        System.out.println("=======onreturn=========, result:"+result);
    }

    @Override
    public void onreturn(String result, String name) {
        System.out.println("==========onreturn==========, result:"+result+",  param:"+name);
    }

    @Override
    public void onthrow(Throwable ex, String name) {
        System.out.println("==========onthrow=============, exception:"+ex.getMessage()+",  param:"+name);
    }
}

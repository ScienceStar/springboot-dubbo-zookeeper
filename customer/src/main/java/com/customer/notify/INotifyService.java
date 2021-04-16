package com.customer.notify;/**
 * @ProjectName: springboot_dubbo_zookeeper
 * @Package: com.customer.notify
 * @ClassName: INotifyService
 * @Author: LXC
 * @Description: 事件通知
 * @Date: 2021/4/16 15:12
 */
public interface INotifyService {
    void oninvoke(String name); // 调用之前
    void onreturnWithoutParam(String result); // 调用之后
    void onreturn(String result, String name); // 调用之后
    void onthrow(Throwable ex, String name);  // 出现异常
}

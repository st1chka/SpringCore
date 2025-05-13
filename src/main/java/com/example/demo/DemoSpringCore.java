package com.example.demo;

import static com.example.demo.notify.NotificationType.EMAIL;
import static com.example.demo.notify.NotificationType.SMS;

import com.example.demo.notify.NotificationSender;
import com.example.demo.notify.NotificationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringCore {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoSpringCore.class, args);
//
//        AppProperties properties = ctx.getBean(AppProperties.class);
//        System.out.println(properties.getName());
//        System.out.println(properties.getVersion());
//
//        GreetingService serv = ctx.getBean(GreetingService.class);
//        serv.greet("world");
//
//        SimpleTimer timer =ctx.getBean(SimpleTimer.class);
//        timer.start();
//        timer.stop();

        /**
         * можно сделать имитацию сканера, чтоб считывать и ответ подставлять в NotificationType
         * но не вижу в этом смысла, ибо приходят команды по ресту, а если по хорошему, то @Scheduler
         * который будет автоматически рассылать сообщения исходя из подписок
         */

        NotificationSender sender = ctx.getBean(NotificationSender.class);
        sender.notifyUser("hello SMS", NotificationType.SMS);
        sender.notifyUser("hello EMAIL", NotificationType.EMAIL);
//
//        ScopeBean bean = ctx.getBean(ScopeBean.class);
//        bean.setData("111");
//        System.out.println(bean.getData());
//
//        System.out.println(ctx.getBean(ScopeBean.class).getData());





    }

}

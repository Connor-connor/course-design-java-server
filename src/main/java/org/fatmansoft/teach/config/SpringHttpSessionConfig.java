package org.fatmansoft.teach.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Configuration:表示当前类是作为配置文件使用的,用来配置容器,放在类的上面
 *
 * SpringConfig类就相当于beans.xml
 * 这里,SpringHttpSessionConfig类就相当于beans.xml
 */

@EnableSpringHttpSession
@Configuration
public class SpringHttpSessionConfig {
    /**
     * 创建方法,方法的返回值是对象,在方法的上面加入@Bean
     * 方法的返回值就注入到容器中
     *
     * @Bean:把对象注入到spring容器中,作用相当于<bean></bean>,放在方法的上面
     * 如果不指定对象的名称,默认是id为方法名
     * 如果指定 @Bean(name = "lisiStudent"),相当于在<bean>中指定id
     * 回头拿到对象时就用指定的name来获取对象,例:
     * ApplicationContext ctx = new AnnotationConfigApplicationContext(MapSessionRepository.class);
     * Student student = (Student) ctx.getBean("lisiStudent");
     */
    @Bean
    public MapSessionRepository sessionRepository() {return new MapSessionRepository(new ConcurrentHashMap<>());
    }
}
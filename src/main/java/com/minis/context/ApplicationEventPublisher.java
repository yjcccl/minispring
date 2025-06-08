package com.minis.context;

/**
 * @author yjc
 * @version 1.0
 * @since 1.0
 */
public interface ApplicationEventPublisher {


    void publishEvent(ApplicationEvent event);

    void addApplicationListener(ApplicationListener listener);

}

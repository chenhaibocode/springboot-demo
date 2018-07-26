package com.chenhaibo.concurrent;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 13:58 2018/7/26
 */
public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}

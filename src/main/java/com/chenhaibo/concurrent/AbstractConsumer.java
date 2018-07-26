package com.chenhaibo.concurrent;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 13:55 2018/7/26
 */
abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

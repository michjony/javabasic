/**   
* @Title: package-info.java 
* @Package com.michjony.basic.util.thread.disruptor 
* @Description: disruptor demo
* @author Michael-jony  
* @date 2017年7月8日 下午8:19:54 
* @version V1.0   
* 1:建立Event类
* 2:建立工厂Event类,用于创建Event类实例对象
* 3:需要一个监听事件类，用于处理数据(Event类)
* 4:实例化Disruptor实例，配置一系列参数，然后对Disruptor实例绑定监听事件类，接受并处理数据
* 5:在Disruptor中,真正存储数据的核心叫做RingBuffer,通过Disruptor实例拿到它，然后把数据生产出来,加入到RingBuffer的实例对象中
*/
package com.michjony.basic.util.thread.disruptor;
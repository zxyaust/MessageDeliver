# MessageDeliver
简单的时间处理,类似于EventBus的轻量级事件分发器,轻松处理fragment之间的数据互调,activity与service数据的互调,非常方便,同时非常简单,不需要学习EventBus复杂的逻辑,对于轻量级的使用足够了
![示例图中显示了activity跳转中的数据传输使用方法][1]
##使用方法
###首先在项目中添加依赖,eclipse中添加library依赖,或者直接下载MessageDeliver.java文件放入自己的项目直接使用,该项目就一个类,十几行代码,非常精简,jcenter依赖如下:
```
compile 'com.z:MessageDeliver:1.0.0'
```
第一个方法:发送消息
参数1:消息类型,参数2:发送的内容,可以是任意对象,参数3:多长时间之后发送
public static void sendMessage(int type, Object msg, long delay)
第二个方法:处理消息的监听
public static void addOnHandleListener(OnHandleListener listener)
```
//在任意地方调用,比如fragment中,service中,等等
  MessageDeliver.sendMessage(1,"哈哈",1000);
 //在任意地方接收并处理该事件
   MessageDeliver.addOnHandleListener(new MessageDeliver.OnHandleListener() {
            @Override
            public void onHandle(int type, Object obj) {//发送时的type,可以判断然后决定是否处理该消息
                if (type == 1) {
                    mTextTextView.setText("123456");
                }
            }
        });
//使用完之后必须在activity等的destroy方法中解除注册,否则如果大量使用可能内存泄露
//MessageDeliver.addOnHandleListener(listener)
```
## 原理简述
采用发布者订阅模式,只要添加订阅,就会接收到发布出来的消息.


  [1]: https://github.com/zxyaust/MessageDeliver/blob/master/SCR_20160718_112544.gif?raw=true
package com.netty;

import com.netty.handler.NettyWSServer;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/14
 */
@SpringBootApplication
public class NettyWSApp implements CommandLineRunner {

    @Autowired
    private NettyWSServer nettyWSServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyWSApp.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFuture future = nettyWSServer.start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                nettyWSServer.destroy();
            }
        });
        //服务端管道关闭的监听器并同步阻塞,直到channel关闭,线程才会往下执行,结束进程
        future.channel().closeFuture().syncUninterruptibly();
    }
}

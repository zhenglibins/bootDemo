package com.example.test.thread;

class Example1 extends Thread {
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
        Example1 thread = new Example1();
        System.out.println( "开始线程" );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "中断线程" );
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println("停止应用程序" );
        //System.exit(0);
    }
    public void run() {
        while(!stop){
            System.out.println( "线程运行中." );
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
            }
        }
        System.out.println("线程运行结束..." );
    }
}
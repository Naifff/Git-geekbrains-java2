package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleServer;

public class ServerThreadMonitor extends Thread{

    Thread mainThread;
    DataToClientThread inputThread;
    DataFromClientThread clientOperThread;

    public ServerThreadMonitor(Thread mainThread, DataToClientThread inputThread, DataFromClientThread clientOperThread) {
        this.mainThread = mainThread;
        this.inputThread = inputThread;
        this.clientOperThread = clientOperThread;
    }

    @Override
    public void run() {
        System.out.println("Threads total = " + mainThread.getThreadGroup().activeCount());
        //while (!isInterrupted()){
        //System.out.println(mainThread.getThreadGroup().);
        while(!isInterrupted()){
            if(!inputThread.isAlive()){
                System.out.println("ServerThreadMonitor:: DataToClientThread was interrupted. Killing DataFromClientThread.");
                clientOperThread.close();
                break;
            }

            if(!clientOperThread.isAlive()){
                System.out.println("ServerThreadMonitor:: DataFromClientThread was interrupted. Killing DataToClientThread.");
                inputThread.close();
                break;
            }
        }

    }


    public void close(){
        interrupt();
        //run();
    }
}

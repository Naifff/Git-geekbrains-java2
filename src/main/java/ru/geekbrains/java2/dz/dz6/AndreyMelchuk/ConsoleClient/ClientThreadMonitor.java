package ru.geekbrains.java2.dz.dz6.AndreyMelchuk.ConsoleClient;


public class ClientThreadMonitor extends Thread{

    Thread mainThread;
    DataToServerThread inputThread;
    DataFromServerThread clientOperThread;

    public ClientThreadMonitor(Thread mainThread, DataToServerThread inputThread, DataFromServerThread clientOperThread) {
        this.mainThread = mainThread;
        this.inputThread = inputThread;
        this.clientOperThread = clientOperThread;
    }

    @Override
    public void run() {
        //System.out.println("Monitor::Client threads total = " + mainThread.getThreadGroup().activeCount());
        while(!isInterrupted()){
            if(!inputThread.isAlive()){
                System.out.println("ClientThreadMonitor:: DataToServerThread was interrupted. Killing DataFromServerThread.");
                clientOperThread.close();
                break;
            }

            if(!clientOperThread.isAlive()){
                System.out.println("DataFromServerThread was interrupted. Killing DataToServerThread thread.");
                inputThread.close();
                break;
            }
        }

    }


    public void close(){
        interrupt();
    }
}

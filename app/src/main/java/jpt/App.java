package jpt;

public class App {
    public static void main(String[] args) {
        try {
            Jprocess.demoProcess();
            Jprocess.getCurrentProcessInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }   

    }
}

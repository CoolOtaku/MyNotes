package sample.java;

public class Potok extends Thread {

    String s;

    public Potok(String s){
        this.s = s;
    }

    @Override
    public void run(){
        try {
            wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String retutnData(){
        return s;
    }
}

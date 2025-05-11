abstract class Appliance {
    public abstract void turnOn();
}

class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Пральна машина ввімкнена.");
    }
}

class Microwave extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Мікрохвильова піч ввімкнена.");
    }
}

interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Грає гітара.");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Грає піаніно.");
    }
}

public class Main {
    public static void main(String[] args) {
        Appliance wm = new WashingMachine();
        Appliance mw = new Microwave();

        wm.turnOn();
        mw.turnOn();

        System.out.println();
        
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}

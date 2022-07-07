package 面向对象.三大特性.多态;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestInstrument {
    public static void main(String[] args) {
        List<Instrument> instruments = new ArrayList<>();
        instruments.add(new Wing());
        instruments.add(new Percussion());

        for(Instrument instrument : instruments) {
            instrument.play();
        }

    }
}

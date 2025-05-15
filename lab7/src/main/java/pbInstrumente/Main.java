package pbInstrumente;

import java.util.Set;



public class Main
{
//    public static void AdaugareInstrument (Set<InstrumentMuzical> Instrumente,InstrumentMuzical im)
//    {
//
//    }



    public static void main(String[] args)
    {
        //1. Creează o colecție de tip Set<InstrumentMuzical> în care utilizând polimorfismul se
        //introduc 3 chitări şi 3 seturi de tobe.
         Set<InstrumentMuzical> Instrumente= null;
         Instrumente.add(new Chitara(6, TipChitara.ELECTRICA));
        Instrumente.add(new Chitara(8, TipChitara.ELECTRICA));

    }
}

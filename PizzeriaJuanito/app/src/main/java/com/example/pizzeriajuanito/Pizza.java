package com.example.pizzeriajuanito;

import java.util.HashMap;
import java.util.Map;

public class Pizza {
    private final Map<String, Integer> PrecioIngredientes = new HashMap<String, Integer>(){{
        put("carne",400);
        put("peperoni",200);
        put("tocino",450);
        put("champi",250);
        put("tomate",200);
        put("choclo",200);
        put("aceituna",250);
    }};
    private final Map<Integer,Integer> PrecioTamaño = new HashMap<Integer,Integer>(){{
       put(0,1500);
       put(1,3000);
       put(2,5000);
    }};
    private int tamaño;
    private Map<String,Boolean> ingredientes;
    public Pizza(int tamaño, ){

    }

}

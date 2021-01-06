package com.lecturador.android.comunicacion;

import java.lang.reflect.Type;

/**
 * Created by Dario Pardo on 4/25/2017.
 */
public class Parametro {
    public String Nomb;
    public Type tipo;
    public Object value;

    public Parametro(String nomb, Type tipo, Object value) {
        Nomb = nomb;
        this.tipo = tipo;
        this.value = value;
    }
}

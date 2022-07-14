package com.example.recycleview;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

import modelo.AlumnosDb;

public class Aplicacion extends Application {
    private static ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;
    private AlumnosDb alumnosDb;

    @Override
    public void onCreate(){
        super.onCreate();
        alumnosDb = new AlumnosDb(getApplicationContext());
        alumnos = alumnosDb.allAlumnos();
        adaptador = new MiAdaptador(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());
    }

    public static ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public MiAdaptador getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(MiAdaptador adaptador) {
        this.adaptador = adaptador;
    }
}

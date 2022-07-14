package com.example.recycleview;
import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
    private String carrera, nombre, matricula;
    private int id;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno(String carrera, String nombre, String img, String matricula) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
        this.img = img;
    }

    public Alumno() {
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static ArrayList<Alumno> llenarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String carrera = "Ing. Tec. Informacion";

        alumnos.add(new Alumno(carrera, "GOMEZ CAMARENA JOSE RICARDO", "android.resource://com.example.recycleview/"+ R.drawable.a01,"2017030274"));
        alumnos.add(new Alumno(carrera, "PEÑA SOLIS DIEGO ARMANDO", "android.resource://com.example.recycleview/"+R.drawable.a02,"2017030432"));
        alumnos.add(new Alumno(carrera, "GARCIA SILVA ADRIAN", "android.resource://com.example.recycleview/"+ R.drawable.a03,"2018030098"));
        alumnos.add(new Alumno(carrera, "GARCIA RODRIGUEZ JESUS EFRAIN", "android.resource://com.example.recycleview/" +R.drawable.a04 ,"2018030099"));
        alumnos.add(new Alumno(carrera, "LIZARRAGA CAMACHO JESUS ARMANDO", "android.resource://com.example.recycleview/"+ R.drawable.a05,"2018030103"));
        alumnos.add(new Alumno(carrera, "GARCIA GOMEZ JUAN ANTONIO", "android.resource://com.example.recycleview/" + R.drawable.a06,"2018030108"));
        alumnos.add(new Alumno(carrera, "LIZARRAGA LUNA JUAN FRANCISCO", "android.resource://com.example.recycleview/"+ R.drawable.a07,"2018030119"));
        alumnos.add(new Alumno(carrera, "OSUNA HIGUERA ALEJANDRO", "android.resource://com.example.recycleview/" + R.drawable.a08,"2018030121"));
        alumnos.add(new Alumno(carrera, "MARIN GALINDO KIMBERLY VANESSA", "android.resource://com.example.recycleview/"+ R.drawable.a10,"2018030133"));
        alumnos.add(new Alumno(carrera, "PERAZA SAINZ ANGEL ADRIAN", "android.resource://com.example.recycleview/"+ R.drawable.a09,"2018030155"));
        return alumnos;
    }
}

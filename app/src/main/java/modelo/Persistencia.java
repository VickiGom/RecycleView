package modelo;

import com.example.recycleview.Alumno;

public interface Persistencia {
    public void openDataBase();
    public void closeDataBase();
    public long insertAlumno(Alumno alumno);
    public long updateAlumno (Alumno alumno);
    public void deleteAlumno(int id);
}
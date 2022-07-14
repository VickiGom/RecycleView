package com.example.recycleview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

import modelo.AlumnosDb;

public class AlumnoAlta extends AppCompatActivity {
    private Button btnGuardar, btnRegresar, btnImagen, btnBorrar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private int posicion;
    private Uri imaU;
    private AlumnosDb alumnoDb;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alumnos_alta);
        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnImagen = (Button) findViewById(R.id.btnImagen);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        txtGrado = findViewById(R.id.txtGrado);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtNombre = findViewById(R.id.txtNombre);
        imgAlumno = findViewById(R.id.imgAlumno);

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if(posicion >= 0){
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getCarrera());
            imgAlumno.setImageURI(Uri.parse(alumno.getImg()));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alumno == null){
                    alumno = new Alumno();
                    alumno.setCarrera(txtGrado.getText().toString());
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImg(imaU.toString());

                    if(validar()){
                        alumnoDb.insertAlumno(alumno);
                        Aplicacion.getAlumnos().add(alumno);
                        setResult(Activity.RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(AlumnoAlta.this, "Falto capturar datos", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();
                    }
                }

                if(posicion >= 0){
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setCarrera(txtGrado.getText().toString());
                    alumno.setImg(imaU.toString());
                    alumnoDb.updateAlumno(alumno);

                    Aplicacion.getAlumnos().get(posicion).setMatricula(alumno.getMatricula());
                    Aplicacion.getAlumnos().get(posicion).setNombre(alumno.getNombre());
                    Aplicacion.getAlumnos().get(posicion).setCarrera(alumno.getCarrera());
                    Aplicacion.getAlumnos().get(posicion).setImg(alumno.getImg());

                    Toast.makeText(AlumnoAlta.this, "Se modificó con exito", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posicion >= 0){
                    Aplicacion.getAlumnos().remove(posicion);
                    alumnoDb.deleteAlumno(alumno.getId());
                    finish();
                }
            }
        });


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarImagen();
            }
        });
    }


    private boolean validar(){
        boolean exito = true;
        Log.d("nombre", "validar " + txtNombre.getText());

        if(txtNombre.getText().toString().equals("")) exito = false;
        if(txtMatricula.getText().toString().equals("")) exito = false;
        if(txtGrado.getText().toString().equals("")) exito = false;

        return exito;
    }
    private void cargarImagen(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Seleccione imagen para su alumno"),200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path= data.getData();
            imgAlumno.setImageURI(path);
            imaU = path;
            imgAlumno.setImageURI(path);
        }  }
}

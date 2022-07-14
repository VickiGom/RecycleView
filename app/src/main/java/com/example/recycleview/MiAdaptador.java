package com.example.recycleview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> implements View.OnClickListener{
    protected ArrayList<Alumno> listAlumnos;
    private View.OnClickListener listener;
    private Context context;
    private LayoutInflater inflater;

    public MiAdaptador(ArrayList<Alumno> listAlumnos, Context context) {
        this.listAlumnos = listAlumnos;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alumnos_items, null);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {
        Alumno alumno = listAlumnos.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.txtCarrera.setText(alumno.getCarrera());
        Uri that = Uri.parse(alumno.getImg());
        holder.idImagen.setImageURI(that);
    }

    @Override
    public int getItemCount() {
        return listAlumnos.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null) listener.onClick(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LayoutInflater inflater;
        private TextView txtNombre, txtMatricula, txtCarrera;
        private ImageView idImagen;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txtAlumnoNombre);
            txtMatricula = itemView.findViewById(R.id.txtMatricula);
            txtCarrera = itemView.findViewById(R.id.txtCarrera);
            idImagen = itemView.findViewById(R.id.foto);
        }

    }
}

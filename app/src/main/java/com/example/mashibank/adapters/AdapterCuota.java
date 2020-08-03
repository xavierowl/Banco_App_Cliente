package com.example.mashibank.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mashibank.R;
import com.example.mashibank.models.Credito;
import com.example.mashibank.models.Cuota;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterCuota extends RecyclerView.Adapter<AdapterCuota.ViewHolder>{
    private List<Cuota> cuotas;
    private Context context;

    public AdapterCuota(){
        cuotas = new ArrayList<Cuota>();
    }

    public void setcuotas(List<Cuota> cuotas){
        this.cuotas = cuotas;
    };

    public List<Cuota> getcuotas(){
        return cuotas;
    };

    public void addCuota(Cuota cuota){
        cuotas.add(cuota);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cuota, parent,
                false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCuota.ViewHolder holder, int position) {
        holder.tvPagado.setText(String.format("%.2f", cuotas.get(position).getSaldo())+
                                "/"+ String.format("%.2f", cuotas.get(position).getMonto()));
        holder.tvEstado.setText(String.valueOf(cuotas.get(position).getEstado().getEtiqueta()));
        holder.tvProximoFecha.setText(String.valueOf(cuotas.get(position).getFechaVencimiento()));
    }

    @Override
    public int getItemCount() {
        return this.cuotas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvEstado;
        TextView tvPagado;
        TextView tvProximoFecha;

        ViewHolder(@NonNull View itemView){
            super(itemView);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvPagado = itemView.findViewById(R.id.tvPagado);
            tvProximoFecha = itemView.findViewById(R.id.tvProximoFecha);
        }
    }
}

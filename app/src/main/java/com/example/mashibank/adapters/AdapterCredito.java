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

import java.util.ArrayList;
import java.util.List;

public class AdapterCredito extends RecyclerView.Adapter<AdapterCredito.ViewHolder>{
    private List<Credito> creditos;
    private Context context;
    private OnCreditoListener onCreditoListener;

    public AdapterCredito(OnCreditoListener onCreditoListener){
        creditos = new ArrayList<Credito>();
        this.onCreditoListener = onCreditoListener;
    }

    public void setCreditos(List<Credito> creditos){
        this.creditos = creditos;
    };

    public List<Credito> getCreditos(){
        return creditos;
    };

    public void addCredito(Credito credito){
        creditos.add(credito);
    }

    public void limpiar(){
        creditos.removeAll(creditos);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credito, parent,
                false);
        context = parent.getContext();
        return new ViewHolder(view, onCreditoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCredito.ViewHolder holder, int position) {
        holder.tvPagado.setText(String.valueOf(String.format("%.2f", creditos.get(position).getMonto())));
        holder.tvTipo.setText(String.valueOf(creditos.get(position).getTipo()));
        holder.tvFechaVencimiento.setText(String.valueOf(creditos.get(position)
                .getFechaVencimiento().toString()));
    }

    @Override
    public int getItemCount() {
        return this.creditos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvPagado;
        TextView tvTipo;
        TextView tvFechaVencimiento;
        OnCreditoListener onCreditoListener;

        ViewHolder(@NonNull View itemView, OnCreditoListener onCreditoListener){
            super(itemView);
            tvPagado = itemView.findViewById(R.id.tvPagado);
            tvTipo = itemView.findViewById(R.id.tvTipoCredito);
            tvFechaVencimiento = itemView.findViewById(R.id.tvFechaVencimiento);

            this.onCreditoListener = onCreditoListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCreditoListener.onCreditoClick(getAdapterPosition());
        }
    }

    public interface OnCreditoListener{
        void onCreditoClick(int credito);
    }
}

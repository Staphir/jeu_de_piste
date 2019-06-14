package jdp.dulieu.com.jeu_de_piste.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import jdp.dulieu.com.jeu_de_piste.R;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

public class JeuListAdapter extends RecyclerView.Adapter<JeuListAdapter.JeuViewHolder>{

    class JeuViewHolder extends RecyclerView.ViewHolder {
        private final TextView jeuItemView;

        private JeuViewHolder(View itemView) {
            super(itemView);
            jeuItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<JeuEntity> jeux = Collections.emptyList(); // Cached copy of words

    public JeuListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public JeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new JeuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JeuViewHolder holder, int position) {
        JeuEntity current = jeux.get(position);
        holder.jeuItemView.setText(current.getNom());
    }

    public void setJeux(List<JeuEntity> jeux) {
        this.jeux = jeux;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return jeux.size();
    }

    public String getJeu(int position){ return jeux.get(position).getNom(); }
}

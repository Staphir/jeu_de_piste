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
import jdp.dulieu.com.jeu_de_piste.database.entity.TeamEntity;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {

    class TeamViewHolder extends RecyclerView.ViewHolder {
        private final TextView teamItemView;

        private TeamViewHolder(View itemView){
            super(itemView);
            teamItemView = itemView.findViewById(R.id.textViewTeam);
        }
    }

    private final LayoutInflater mInflater;
    private List<TeamEntity> teamEntities = Collections.emptyList();

    public TeamListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerviewteam_item, parent, false);
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamEntity current = teamEntities.get(position);
        holder.teamItemView.setText(current.getNom());
    }

    public void setJeux(List<TeamEntity> teamEntities) {
        this.teamEntities = teamEntities;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return teamEntities.size();
    }

    public Integer getTypeTeam(int position){ return teamEntities.get(position).getNum(); }

    public void setTeamName(int position, String name){teamEntities.get(position).setNom(name);}

    public String getTeamName(int position){return teamEntities.get(position).getNom();}
}

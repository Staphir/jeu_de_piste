package jdp.dulieu.com.jeu_de_piste.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import jdp.dulieu.com.jeu_de_piste.R;
//
//public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {
//
//    class TeamViewHolder extends RecyclerView.ViewHolder {
//        private final TextView teamItemView;
//
//        private TeamViewHolder(View itemView){
//            super(itemView);
//            teamItemView = itemView.findViewById(R.id.textView);
//        }
//    }
//
//    private final LayoutInflater mInflater;
//    private List<TeamEntity> teamEntities = Collections.emptyList();
//
//    public TeamListAdapter(Context context){
//        mInflater = LayoutInflater.from(context);
//    }
//
//
//    @NonNull
//    @Override
//    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
//        return new TeamViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
//        TeamEntity current = teamEntities.get(position);
//        holder.teamItemView.setText(current.getNom());
//    }
//
//    public void setJeux(List<TeamEntity> teamEntities) {
//        this.teamEntities = teamEntities;
//        notifyDataSetChanged();
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return teamEntities.size();
//    }
//
//    public Integer getTypeTeam(int position){ return teamEntities.get(position).getNum(); }
//
//    public void setTeamName(int position, String name){teamEntities.get(position).setNom(name);}
//
//    public String getTeamName(int position){return teamEntities.get(position).getNom();}
//}

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {
    private ArrayList<String> listTeams;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public TeamViewHolder (TextView v) {
            super(v);
            textView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TeamListAdapter(ArrayList<String> teams) {
        listTeams = teams;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.textview_team, parent, false);
        TeamViewHolder teamViewHolder = new TeamViewHolder(v);
        return teamViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(listTeams.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listTeams.size();
    }
}

package jdp.dulieu.com.jeu_de_piste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import jdp.dulieu.com.jeu_de_piste.Adapter.TeamListAdapter;
import jdp.dulieu.com.jeu_de_piste.viewmodel.JeuViewModel;

public class TeamActivity extends AppCompatActivity {

    private JeuViewModel jeuViewModel;
    private TextView teamText;
    private Integer nbTeam;
    private ArrayList<String> listTeams;
    private Integer teamChoose;
    private Boolean isSelected;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View viewSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        viewSelected = new View(this);
        isSelected = false;
        teamText = findViewById(R.id.teamTexteView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        nbTeam = Integer.parseInt(Objects.requireNonNull(bundle.getString("nbTeam")));

        listTeams = new ArrayList<>();

        for(int i=0;i<nbTeam;i++){
            listTeams.add("Equipe n°"+(i+1));
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new TeamListAdapter(listTeams);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(isSelected){
                    viewSelected.setBackgroundResource(R.color.colorHollow);
                }
                isSelected = true;
                view.setBackgroundResource(R.color.colorSelection);
                viewSelected = view;
                teamChoose = position+1;
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
}

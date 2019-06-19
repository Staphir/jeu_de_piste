package jdp.dulieu.com.jeu_de_piste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import jdp.dulieu.com.jeu_de_piste.Adapter.JeuListAdapter;
import jdp.dulieu.com.jeu_de_piste.viewmodel.JeuViewModel;

public class TeamActivity extends AppCompatActivity {

    private JeuViewModel jeuViewModel;
    private TextView teamText;
    private Integer nbTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        teamText = findViewById(R.id.teamTexteView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        nbTeam = Integer.parseInt(Objects.requireNonNull(bundle.getString("nbTeam")));


        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(recyclerView) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        Toast.makeText(this, nbTeam.toString()+nbTeam.getClass().toString(),Toast.LENGTH_SHORT).show();
        final JeuListAdapter adapter = new JeuListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jeuViewModel = ViewModelProviders.of(this).get(JeuViewModel.class);



    }
}

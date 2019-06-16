package jdp.dulieu.com.jeu_de_piste;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jdp.dulieu.com.jeu_de_piste.Adapter.JeuListAdapter;
import jdp.dulieu.com.jeu_de_piste.viewmodel.JeuViewModel;

public class TeamActivity extends AppCompatActivity {

    private JeuViewModel jeuViewModel;
    private TextView teamText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        teamText = findViewById(R.id.teamTexteView);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final JeuListAdapter adapter = new JeuListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jeuViewModel = ViewModelProviders.of(this).get(JeuViewModel.class);

    }
}

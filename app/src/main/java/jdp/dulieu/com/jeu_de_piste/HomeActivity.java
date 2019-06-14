package jdp.dulieu.com.jeu_de_piste;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.Adapter.JeuListAdapter;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;
import jdp.dulieu.com.jeu_de_piste.viewmodel.JeuViewModel;

public class HomeActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    private JeuViewModel jeuViewModel;

    private String teamName;
    private String gameName;
    private Integer typeTeam;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        teamName = new String("");
        gameName = new String("");
        typeTeam = 0;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final JeuListAdapter adapter = new JeuListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        jeuViewModel = ViewModelProviders.of(this).get(JeuViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        jeuViewModel.getAllJeux().observe(this, new Observer<List<JeuEntity>>() {
            @Override
            public void onChanged(@Nullable final List<JeuEntity> jeux) {
                // Update the cached copy of the words in the adapter.
                adapter.setJeux(jeux);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!teamName.equals("") && !gameName.equals("") && typeTeam!=0){
                    openGameActivity();
                }
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                gameName = adapter.getJeu(position);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void openGameActivity(){

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

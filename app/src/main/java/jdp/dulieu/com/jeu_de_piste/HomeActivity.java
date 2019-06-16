package jdp.dulieu.com.jeu_de_piste;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    private JeuViewModel jeuViewModel;

    private String teamName;
    private String gameName;
    private Integer typeTeam;

    private TextView homeText;
    private EditText inputTextTeam;

    private View viewSelected;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        teamName = "";
        gameName = "";
        typeTeam = 0;

        homeText = findViewById(R.id.homeTexteView);
        inputTextTeam = findViewById(R.id.nomEquipeInput);
        inputTextTeam.setSelected(false);


        viewSelected = new View(this);


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
                teamName = inputTextTeam.getText().toString();
                if(!teamName.equals("") && !gameName.equals("")){
                    openTeamActivity();
                }
            }
        });

        //touch on recycle view
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(viewSelected.findViewById(R.id.textView) != null){
                    viewSelected.findViewById(R.id.textView).setBackgroundResource(R.color.colorHollow);
                }
                view.findViewById(R.id.textView).setBackgroundResource(R.color.colorSelection);
                viewSelected = view;
                gameName = adapter.getJeu(position);
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //touch on under recycle view
//        recyclerViewTeam.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewTeam, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//
//                typeTeam = position;
//
//            }
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
    }

    public void openTeamActivity(){

        Intent intent = new Intent(this, TeamActivity.class);
        startActivity(intent);
    }
}

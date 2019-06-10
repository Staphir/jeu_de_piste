package jdp.dulieu.com.jeu_de_piste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jdp.dulieu.com.jeu_de_piste.Adapter.JeuListAdapter;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;
import jdp.dulieu.com.jeu_de_piste.viewmodel.JeuViewModel;

public class HomeActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private Button validate_button;

    private JeuViewModel jeuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
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
        validate_button = (Button) findViewById(R.id.validate_button);
        validate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });
    }

    protected void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

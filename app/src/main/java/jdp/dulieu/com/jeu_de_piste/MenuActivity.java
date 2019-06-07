package jdp.dulieu.com.jeu_de_piste;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.IOException;

import jdp.dulieu.com.jeu_de_piste.database.AppDatabase;
import jdp.dulieu.com.jeu_de_piste.database.entity.JeuEntity;

public class MenuActivity extends AppCompatActivity {

    private Button validate_button;
    private TextView textView;

    private JeuEntity jeuEntity;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        validate_button = (Button) findViewById(R.id.validate_button);
        validate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "jdpDatabase").build();

        textView = (TextView) findViewById(R.id.textView);
        JeuEntity jeuEntity = new JeuEntity();
        jeuEntity = db.jeuEntity();
        String nom = jeuEntity.nom;
        textView.setText(nom);

    }

        public void createDb() {
            Context context = ApplicationProvider.getApplicationContext();
            db = Room.inMemoryDatabaseBuilder(context, TestDatabase.class).build();
            userDao = db.getUserDao();
        }

        public void closeDb() throws IOException {
            db.close();
        }

        public void writeUserAndReadInList() throws Exception {
            User user = TestUtil.createUser(3);
            user.setName("george");
            userDao.insert(user);
            List<User> byName = userDao.findUsersByName("george");
            assertThat(byName.get(0), equalTo(user));
        }
    }


    protected void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jeu_table")
public class JeuEntity {

    @PrimaryKey(autoGenerate = true)
    public int jeu_id;

    @ColumnInfo(name = "nom")
    @NonNull
    private String nom;

    public JeuEntity(@NonNull String nom){this.nom = nom;}

    public int getJeu_id() {
        return jeu_id;
    }

    @NonNull
    public String getNom() {
        return nom;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }
}

package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jeu_table")
public class JeuEntity {

    @PrimaryKey(autoGenerate = true)
    public Integer jeu_id;

    @ColumnInfo(name = "nom")
    @NonNull
    private String nom;

    @ColumnInfo(name = "nbTeam")
    @NonNull
    private Integer nbTeam;

    public JeuEntity(@NonNull String nom, @NonNull Integer nbTeam){
        this.nom = nom;
        this.nbTeam = nbTeam;
    }

    public Integer getJeu_id() {
        return jeu_id;
    }

    @NonNull
    public String getNom() {
        return nom;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }

    @NonNull
    public Integer getNbTeam() {
        return nbTeam;
    }
}

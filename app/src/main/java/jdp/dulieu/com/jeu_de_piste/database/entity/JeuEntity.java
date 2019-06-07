package jdp.dulieu.com.jeu_de_piste.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class JeuEntity {
    @PrimaryKey
    public int jeu_id;

    @ColumnInfo(name = "nom")
    public String nom;

}

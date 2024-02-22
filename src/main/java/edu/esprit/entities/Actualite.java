package edu.esprit.entities;

    import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Actualite {
    int id_a;
    String titre_a;
    String Description_a;
    Date date_a;
    String image_a ;
   Muni muni ;


    public Actualite(String titre_a, String description_a, Date date_a, String image_a, Muni muni) {
        this.titre_a = titre_a;
        Description_a = description_a;
        this.date_a = date_a;
        this.image_a = image_a;
        this.muni = muni;
    }

    public Actualite(int id_a, Muni muni) {
        this.id_a = id_a;
        this.muni = muni;
    }

    public Actualite(String titre_a, String description_a, Muni muni) {
        this.titre_a = titre_a;
        Description_a = description_a;
        this.muni = muni;
    }

    public Actualite(int id_a, String titre_a, String description_a, Date date_a, String image_a, Muni muni) {
        this.id_a = id_a;
        this.titre_a = titre_a;
        Description_a = description_a;
        this.date_a = date_a;
        this.image_a = image_a;
        this.muni = muni;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getTitre_a() {
        return titre_a;
    }

    public void setTitre_a(String titre_a) {
        this.titre_a = titre_a;
    }

    public String getDescription_a() {
        return Description_a;
    }

    public void setDescription_a(String description_a) {
        Description_a = description_a;
    }


    public java.sql.Date getDate_a() {
        return (java.sql.Date) date_a;
    }

    public String getImage_a() {
        return image_a;
    }

    public void setImage_a(String image_a) {
        this.image_a = image_a;
    }

    public void setDate_a(Date date_a) {
        this.date_a = date_a;
    }

    public Muni getMuni() {
        return muni;
    }

    public void setMuni(Muni muni) {
        this.muni = muni;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actualite actualite = (Actualite) o;
        return id_a == actualite.id_a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_a);
    }

    @Override
    public String toString() {
        return "Actualite{" +
                "titre_a='" + titre_a + '\'' +
                ", Description_a='" + Description_a + '\'' +
                ", date_a=" + date_a +
                ", image_a='" + image_a + '\'' +
                ", muni=" + muni +
                '}';

    }

}


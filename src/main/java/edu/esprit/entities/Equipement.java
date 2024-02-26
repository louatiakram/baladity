package edu.esprit.entities;

public class Equipement {
    private int id_eq;
    private String ref_eq;
    private String nom_eq;
    private String image_eq;
    private String typeMateriel_eq;
    private int quantite_eq;
    private String etat_eq;
    private String description_eq;
    private EndUser user;
    private Muni muni;
    public Equipement(){
    }

    public Equipement(int id_eq) {
        this.id_eq = id_eq;
    }

    public Equipement(String ref_eq, String nom_eq, String typeMateriel_eq, int quantite_eq, String etat_eq, String description_eq) {
        this.ref_eq = ref_eq;
        this.nom_eq = nom_eq;
        this.typeMateriel_eq = typeMateriel_eq;
        this.quantite_eq = quantite_eq;
        this.etat_eq = etat_eq;
        this.description_eq = description_eq;
    }

    public Equipement(String ref_eq, String nom_eq, String image_eq, String typeMateriel_eq, int quantite_eq, String etat_eq, String description_eq, EndUser user, Muni muni) {
        this.ref_eq = ref_eq;
        this.nom_eq = nom_eq;
        this.image_eq = image_eq;
        this.typeMateriel_eq = typeMateriel_eq;
        this.quantite_eq = quantite_eq;
        this.etat_eq = etat_eq;
        this.description_eq = description_eq;
        this.user = user;
        this.muni = muni;
    }

    public Equipement(int id_eq, String ref_eq, String nom_eq, String image_eq, String typeMateriel_eq, int quantite_eq, String etat_eq, String description_eq, EndUser user,Muni muni) {
        this.id_eq = id_eq;
        this.ref_eq = ref_eq;
        this.nom_eq = nom_eq;
        this.image_eq = image_eq;
        this.typeMateriel_eq = typeMateriel_eq;
        this.quantite_eq = quantite_eq;
        this.etat_eq = etat_eq;
        this.description_eq = description_eq;
        this.user = user;
        this.muni=muni;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "ref_eq='" + ref_eq + '\'' +
                ", nom_eq='" + nom_eq + '\'' +
                ", image_eq='" + image_eq + '\'' +
                ", typeMateriel_eq='" + typeMateriel_eq + '\'' +
                ", quantite_eq=" + quantite_eq +
                ", etat_eq='" + etat_eq + '\'' +
                ", description_eq='" + description_eq + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Equipement that = (Equipement) object;
        return id_eq == that.id_eq;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id_eq);
    }

    public int getId_eq() {
        return id_eq;
    }

    public void setId_eq(int id_eq) {
        this.id_eq = id_eq;
    }

    public String getRef_eq() {
        return ref_eq;
    }

    public void setRef_eq(String ref_eq) {
        this.ref_eq = ref_eq;
    }

    public String getNom_eq() {
        return nom_eq;
    }

    public void setNom_eq(String nom_eq) {
        this.nom_eq = nom_eq;
    }

    public String getTypeMateriel_eq() {
        return typeMateriel_eq;
    }

    public void setTypeMateriel_eq(String typeMateriel_eq) {
        this.typeMateriel_eq = typeMateriel_eq;
    }

    public int getQuantite_eq() {
        return quantite_eq;
    }

    public void setQuantite_eq(int quantite_eq) {
        this.quantite_eq = quantite_eq;
    }

    public String getEtat_eq() {
        return etat_eq;
    }

    public void setEtat_eq(String etat_eq) {
        this.etat_eq = etat_eq;
    }

    public String getDescription_eq() {
        return description_eq;
    }

    public void setDescription_eq(String description_eq) {
        this.description_eq = description_eq;
    }

    public String getImage_eq() {
        return image_eq;
    }

    public void setImage_eq(String image_eq) {
        this.image_eq = image_eq;
    }

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }

    public Muni getMuni() {
        return muni;
    }

    public void setMuni(Muni muni) {
        this.muni = muni;
    }
}
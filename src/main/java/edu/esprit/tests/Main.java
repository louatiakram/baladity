package edu.esprit.tests;

import edu.esprit.entities.Actualite;
import edu.esprit.entities.Muni;
import edu.esprit.entities.EndUser;
import edu.esprit.entities.Publicite;
import edu.esprit.services.ServiceActualite;
import edu.esprit.services.ServicePublicite;
import edu.esprit.utils.DataSource;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ServicePublicite sp1 = new ServicePublicite();
        ServiceActualite sp2 = new ServiceActualite();
        Muni muni = new Muni(1);
        EndUser user = new EndUser(12,muni);
        Actualite actualite = new Actualite(27,muni);
        java.sql.Date sqlDate2 = new java.sql.Date(new Date().getTime());

       sp1.ajouter(new Publicite("pub1","about the vehicules",94007815,"tunis","img1",user,actualite));
       //sp1.modifier(new Publicite(464,"aaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbb", 00000, "la petite ariana","afzgzeg",1,24));
        // sp1.modifier(new Publicite(453,"amine", "yah", 4, "","",12,24));
        // sp1.supprimer(461);
       //System.out.println(sp1.getAll());
        java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

      //  sp2.ajouter(new Actualite("siamine", "yahyaouii", sqlDate, "image",muni));
        //sp2.supprimer(1);


        java.sql.Date sqlDate1 = new java.sql.Date(new Date().getTime());
        //sp2.modifier(new Actualite(26,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","bbbbbbbbbbbbbbbbb",sqlDate1,"asss",1));
        //System.out.println(sp2.getAll());

    }
}

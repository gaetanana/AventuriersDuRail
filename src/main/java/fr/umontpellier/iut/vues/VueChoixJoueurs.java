package fr.umontpellier.iut.vues;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * Cette classe correspond à une nouvelle fenêtre permettant de choisir le nombre et les noms des joueurs de la partie.
 * <p>
 * Sa présentation graphique peut automatiquement être actualisée chaque fois que le nombre de joueurs change.
 * Lorsque l'utilisateur a fini de saisir les noms de joueurs, il demandera à démarrer la partie.
 */
public class VueChoixJoueurs extends Stage {

    @FXML
    private Button boutonLancement;

    @FXML
    private Button boutonRegle;

    @FXML
    private TextField nomJoueur1;
    @FXML
    private TextField nomJoueur2;
    @FXML
    private TextField nomJoueur3;
    @FXML
    private TextField nomJoueur4;
    @FXML
    private TextField nomJoueur5;

    private ArrayList<String> listeNomJoueur = new ArrayList<>();


    private ObservableList<String> nomsJoueurs;

    public ObservableList<String> nomsJoueursProperty() {
        return nomsJoueurs;
    }

    public List<String> getNomsJoueurs() {
        return nomsJoueurs;
    }

    public VueChoixJoueurs() {
        AnchorPane ap = null;

        try {
            FXMLLoader loaderPageAcceuil = new FXMLLoader(getClass().getClassLoader().getResource("fxml/pageAcceuilGaetan.fxml"));
            //loaderPageAcceuil.setRoot(this);
            loaderPageAcceuil.setController(this);
            ap = loaderPageAcceuil.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(ap);
        setScene(scene);


        nomsJoueurs = FXCollections.observableArrayList();
        boutonLancement.setOnAction(boutonLancementCLique);
        boutonRegle.setOnAction(boutonRegleClique);

    }

    EventHandler<ActionEvent> boutonRegleClique = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {


            URL fetchWebsite = null;
            try {
                fetchWebsite = new URL("https://www.jeuxavolonte.asso.fr/regles/les_aventuriers_du_rail.pdf");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            ReadableByteChannel readableByteChannel = null;
            try {
                readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileOutputStream fos = new FileOutputStream("règle.pdf")) {
                fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    };

    EventHandler<ActionEvent> boutonLancementCLique = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            List<String> listeTempoNomJoueur = new ArrayList<>();



            if (!Objects.equals(nomJoueur1.getText(), "")) {
                listeTempoNomJoueur.add(nomJoueur1.getText());
            }
            if (!Objects.equals(nomJoueur2.getText(), "")) {
                listeTempoNomJoueur.add(nomJoueur2.getText());
            }
            if (!Objects.equals(nomJoueur3.getText(), "")) {
                listeTempoNomJoueur.add(nomJoueur3.getText());
            }
            if (!Objects.equals(nomJoueur4.getText(), "")) {
                listeTempoNomJoueur.add(nomJoueur4.getText());
            }
            if (!Objects.equals(nomJoueur5.getText(), "")) {
                listeTempoNomJoueur.add(nomJoueur5.getText());
            }
            /*System.out.println("Joueur 1 : " +nomJoueur1.getText());
            System.out.println("Joueur 2 : " +nomJoueur2.getText());
            System.out.println("Joueur 3 : " +nomJoueur3.getText());
            System.out.println("Joueur 4 : " +nomJoueur4.getText());
            System.out.println("Joueur 5 : " + nomJoueur5.getText());*/




            listeNomJoueur.addAll(listeTempoNomJoueur);


            setListeDesNomsDeJoueurs();


        }
    };

    /**
     * Définit l'action à exécuter lorsque la liste des participants est correctement initialisée
     */
    public void setNomsDesJoueursDefinisListener(ListChangeListener<String> quandLesNomsDesJoueursSontDefinis) {
        nomsJoueursProperty().addListener(quandLesNomsDesJoueursSontDefinis);
    }

    /**
     * Définit l'action à exécuter lorsque le nombre de participants change
     */
    protected void setChangementDuNombreDeJoueursListener(ChangeListener<Integer> quandLeNombreDeJoueursChange) {
    }

    /**
     * Vérifie que tous les noms des participants sont renseignés
     * et affecte la liste définitive des participants
     */
    protected void setListeDesNomsDeJoueurs() {
        ArrayList<String> tempNamesList = new ArrayList<>();
        for (int i = 1; i <= getNombreDeJoueurs(); i++) {
            String name = getJoueurParNumero(i);
            if (name == null || name.equals("")) {
                tempNamesList.clear();
                break;
            } else
                tempNamesList.add(name);
        }
        if (!tempNamesList.isEmpty()) {
            hide();
            nomsJoueurs.clear();
            nomsJoueurs.addAll(tempNamesList);
        }
    }

    /**
     * Retourne le nombre de participants à la partie que l'utilisateur a renseigné
     */
    protected int getNombreDeJoueurs() {
        //System.out.println(listeNomJoueur.size());
        return listeNomJoueur.size()
                ;
    }

    /**
     * Retourne le nom que l'utilisateur a renseigné pour le ième participant à la partie
     *
     * @param playerNumber : le numéro du participant
     */
    protected String getJoueurParNumero(int playerNumber) {
        return listeNomJoueur.get(playerNumber - 1);
    }

}

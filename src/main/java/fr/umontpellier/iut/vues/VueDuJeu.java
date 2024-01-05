package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.IDestination;
import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.rails.Destination;
import fr.umontpellier.iut.rails.Joueur;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cette classe correspond à la fenêtre principale de l'application.
 * <p>
 * Elle est initialisée avec une référence sur la partie en cours (Jeu).
 * <p>
 * On y définit les bindings sur les éléments internes qui peuvent changer
 * (le joueur courant, les 5 cartes Wagons visibles, les destinations lors de l'étape d'initialisation de la partie, ...)
 * ainsi que les listeners à exécuter lorsque ces éléments changent
 */
public class VueDuJeu extends BorderPane {

    private IJeu jeu;
    @FXML
    private Button boutonPasser;

    @FXML
    private HBox plateau;
    @FXML
    private HBox vueJoueurCourant;
    @FXML
    private VBox vueAutreJoueur;
    @FXML
    private VBox vueCarteVisible;

    @FXML
    private Label instructionCourante;

    @FXML
    public Label tour;

    @FXML
    public Label labelDestination;

    @FXML
    public Button boutonTerminer;

    public Label getTour() {
        return tour;
    }

    public Label getLabelDestination() {
        return labelDestination;
    }

    private VueJoueurCourant vueJoueurCourantJava;
    private VuePlateau vuePlateau;
    private VueAutresJoueurs vueAutresJoueurs;
    private VueCarteVisible vueCarteVisibleJava;
    private VueFinPartie vueFinPartie;


    private int compteurTour;

    public VueDuJeu(IJeu jeu) {
        this.jeu = jeu;

        try {
            FXMLLoader loaderCarte = new FXMLLoader(getClass().getClassLoader().getResource("fxml/maquetteFXML.fxml"));
            loaderCarte.setRoot(this);
            loaderCarte.setController(this);
            loaderCarte.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        compteurTour = 0;


        vuePlateau = new VuePlateau();
        plateau.getChildren().add(vuePlateau);

        vueCarteVisibleJava = new VueCarteVisible();
        vueCarteVisible.getChildren().add(vueCarteVisibleJava);


        vueJoueurCourantJava = new VueJoueurCourant();
        vueJoueurCourant.getChildren().add(vueJoueurCourantJava);

        vueAutresJoueurs = new VueAutresJoueurs();
        vueAutreJoueur.getChildren().add(vueAutresJoueurs);

    }

    EventHandler<ActionEvent> boutonRegleClique = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {


            ((Stage) getScene().getWindow()).close();

            Stage stageFinPartie = new Stage();
            vueFinPartie = new VueFinPartie();



            List<Joueur> nomJoueurTempo1 = jeu.getJoueurs();
            List<String> nomJoueurTempo = new ArrayList<>();

            for (Joueur joueur : nomJoueurTempo1) {

                nomJoueurTempo.add(joueur.getNom());
                System.out.println(joueur.getNom() + joueur.getCouleur());
            }

            while (!nomJoueurTempo.isEmpty()) {
                String nom = nomJoueurTempo.remove(0);
                System.out.println("ici");
                if (Objects.equals(vueFinPartie.getNomJoueur1().getText(), "")) {


                    vueFinPartie.getNomJoueur1().setText(nom);
                    String couleurJ1Francais = "";


                    for (Joueur joueur : jeu.getJoueurs()) {
                        if (Objects.equals(joueur.getNom(), nom)) {
                            couleurJ1Francais = joueur.getCouleur().toString();
                            System.out.println(couleurJ1Francais);
                        }
                    }

                    String couleur = "";
                    if (Objects.equals(couleurJ1Francais, "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";
                        Image avatarVert = new Image("images/avatar-VERT.png");

                        vueFinPartie.getImageJoueur1().setImage(avatarVert);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                        vueFinPartie.getImagewagonj1().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                        vueFinPartie.getImagegarej1().setImage(carteGareCouleur);


                    }

                    if (Objects.equals(couleurJ1Francais, "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";
                        Image avatarRose = new Image("images/AVATAR-ROSE.png");
                        vueFinPartie.getImageJoueur1().setImage(avatarRose);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                        vueFinPartie.getImagewagonj1().setImage(carteWagonCouleur);


                        Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                        vueFinPartie.getImagegarej1().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ1Francais, "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";
                        Image avatarBleu = new Image("images/avatar-BLEU.png");
                        vueFinPartie.getImageJoueur1().setImage(avatarBleu);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                        vueFinPartie.getImagewagonj1().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                        vueFinPartie.getImagegarej1().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ1Francais, "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";
                        Image avatarJaune = new Image("images/avatar-JAUNE.png");
                        vueFinPartie.getImageJoueur1().setImage(avatarJaune);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                        vueFinPartie.getImagewagonj1().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                        vueFinPartie.getImagegarej1().setImage(carteGareCouleur);

                    }

                    if (Objects.equals(couleurJ1Francais, "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";
                        Image avatarRouge = new Image("images/avatar-ROUGE.png");
                        vueFinPartie.getImageJoueur1().setImage(avatarRouge);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                        vueFinPartie.getImagewagonj1().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                        vueFinPartie.getImagegarej1().setImage(carteGareCouleur);
                    }

                    vueFinPartie.getCadreJoueur1().setStyle(couleur);

                } else if (Objects.equals(vueFinPartie.getNomJoueur2().getText(), "")) {
                    vueFinPartie.getNomJoueur2().setText(nom);

                    String couleurJ2Francais = "";
                    for (Joueur joueur : jeu.getJoueurs()) {
                        if (Objects.equals(joueur.getNom(), nom)) {
                            couleurJ2Francais = joueur.getCouleur().toString();
                        }
                    }

                    String couleur = "";

                    if (Objects.equals(couleurJ2Francais, "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                        Image avatarVert = new Image("images/avatar-VERT.png");

                       vueFinPartie.getImageJoueur2().setImage(avatarVert);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                        vueFinPartie.getImagewagonj2().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                        vueFinPartie.getImagegarej2().setImage(carteGareCouleur);


                    }

                    if (Objects.equals(couleurJ2Francais, "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                        Image avatarRose = new Image("images/AVATAR-ROSE.png");

                        vueFinPartie.getImageJoueur2().setImage(avatarRose);

                        Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                        vueFinPartie.getImagewagonj2().setImage(carteWagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                        vueFinPartie.getImagegarej2().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ2Francais, "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                        Image avatarBleu = new Image("images/avatar-BLEU.png");

                        vueFinPartie.getImageJoueur2().setImage(avatarBleu);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                        vueFinPartie.getImagewagonj2().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                        vueFinPartie.getImagegarej2().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ2Francais, "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                        Image avatarJaune = new Image("images/avatar-JAUNE.png");
                        vueFinPartie.getImageJoueur2().setImage(avatarJaune);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                        vueFinPartie.getImagewagonj2().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                        vueFinPartie.getImagegarej2().setImage(carteGareCouleur);

                    }

                    if (Objects.equals(couleurJ2Francais, "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                        Image avatarRouge = new Image("images/avatar-ROUGE.png");

                        vueFinPartie.getImageJoueur2().setImage(avatarRouge);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                        vueFinPartie.getImagewagonj2().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                        vueFinPartie.getImagegarej2().setImage(carteGareCouleur);

                    }

                    vueFinPartie.getCadreJoueur2().setStyle(couleur);


                } else if (Objects.equals(vueFinPartie.getNomJoueur3().getText(), "")) {
                    vueFinPartie.getNomJoueur3().setText(nom);

                    String couleurJ3Francais = "";
                    for (Joueur joueur : jeu.getJoueurs()) {
                        if (Objects.equals(joueur.getNom(), nom)) {
                            couleurJ3Francais = joueur.getCouleur().toString();
                        }
                    }

                    String couleur = "";

                    if (Objects.equals(couleurJ3Francais, "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                        Image avatarVert = new Image("images/avatar-VERT.png");

                        vueFinPartie.getImageJoueur3().setImage(avatarVert);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                        vueFinPartie.getImagewagonj3().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                        vueFinPartie.getImagegarej3().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ3Francais, "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                        Image avatarRose = new Image("images/AVATAR-ROSE.png");

                        vueFinPartie.getImageJoueur3().setImage(avatarRose);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                        vueFinPartie.getImagewagonj3().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                        vueFinPartie.getImagegarej3().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ3Francais, "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";
                        Image avatarBleu = new Image("images/avatar-BLEU.png");

                        vueFinPartie.getImageJoueur3().setImage(avatarBleu);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                        vueFinPartie.getImagewagonj3().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                        vueFinPartie.getImagegarej3().setImage(carteGareCouleur);

                    }

                    if (Objects.equals(couleurJ3Francais, "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                        Image avatarJaune = new Image("images/avatar-JAUNE.png");

                        vueFinPartie.getImageJoueur3().setImage(avatarJaune);


                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                        vueFinPartie.getImagewagonj3().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                        vueFinPartie.getImagegarej3().setImage(carteGareCouleur);

                    }

                    if (Objects.equals(couleurJ3Francais, "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                        Image avatarRouge = new Image("images/avatar-ROUGE.png");

                        vueFinPartie.getImageJoueur3().setImage(avatarRouge);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                        vueFinPartie.getImagewagonj3().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                        vueFinPartie.getImagegarej3().setImage(carteGareCouleur);
                    }

                    vueFinPartie.getCadreJoueur3().setStyle(couleur);
                } else if (Objects.equals(vueFinPartie.getNomJoueur4().getText(), "")) {
                    vueFinPartie.getNomJoueur4().setText(nom);

                    String couleurJ4Francais = "";
                    for (Joueur joueur : jeu.getJoueurs()) {
                        if (Objects.equals(joueur.getNom(), nom)) {
                            couleurJ4Francais = joueur.getCouleur().toString();
                        }
                    }

                    String couleur = "";

                    if (Objects.equals(couleurJ4Francais, "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                        Image avatarVert = new Image("images/avatar-VERT.png");

                        vueFinPartie.getImageJoueur4().setImage(avatarVert);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                        vueFinPartie.getImagewagonj4().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                        vueFinPartie.getImagegarej4().setImage(carteGareCouleur);

                    }

                    if (Objects.equals(couleurJ4Francais, "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                        Image avatarRose = new Image("images/AVATAR-ROSE.png");

                        vueFinPartie.getImageJoueur4().setImage(avatarRose);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                        vueFinPartie.getImagewagonj4().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                        vueFinPartie.getImagegarej4().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ4Francais, "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                        Image avatarBleu = new Image("images/avatar-BLEU.png");

                        vueFinPartie.getImageJoueur4().setImage(avatarBleu);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                        vueFinPartie.getImagewagonj4().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                        vueFinPartie.getImagegarej4().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ4Francais, "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                        Image avatarJaune = new Image("images/avatar-JAUNE.png");

                        vueFinPartie.getImageJoueur4().setImage(avatarJaune);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                        vueFinPartie.getImagewagonj4().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                        vueFinPartie.getImagegarej4().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ4Francais, "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                        Image avatarRouge = new Image("images/avatar-ROUGE.png");

                        vueFinPartie.getImageJoueur4().setImage(avatarRouge);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                        vueFinPartie.getImagewagonj4().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                        vueFinPartie.getImagegarej4().setImage(carteGareCouleur);
                    }

                    vueFinPartie.getCadreJoueur4().setStyle(couleur);

                } else if (Objects.equals(vueFinPartie.getNomJoueur5().getText(), "")) {
                    vueFinPartie.getNomJoueur5().setText(nom);

                    String couleurJ5Francais = "";
                    for (Joueur joueur : jeu.getJoueurs()) {
                        if (Objects.equals(joueur.getNom(), nom)) {
                            couleurJ5Francais = joueur.getCouleur().toString();
                        }
                    }

                    String couleur = "";

                    if (Objects.equals(couleurJ5Francais, "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                        Image avatarVert = new Image("images/avatar-VERT.png");

                        vueFinPartie.getImageJoueur5().setImage(avatarVert);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                        vueFinPartie.getImagewagonj5().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                        vueFinPartie.getImagegarej5().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ5Francais, "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                        Image avatarRose = new Image("images/AVATAR-ROSE.png");

                        vueFinPartie.getImageJoueur5().setImage(avatarRose);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                        vueFinPartie.getImagewagonj5().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                        vueFinPartie.getImagegarej5().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ5Francais, "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                        Image avatarBleu = new Image("images/avatar-BLEU.png");

                        vueFinPartie.getImageJoueur5().setImage(avatarBleu);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                        vueFinPartie.getImagewagonj5().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                        vueFinPartie.getImagegarej5().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ5Francais, "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                        Image avatarJaune = new Image("images/avatar-JAUNE.png");

                        vueFinPartie.getImageJoueur5().setImage(avatarJaune);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                        vueFinPartie.getImagewagonj5().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                        vueFinPartie.getImagegarej5().setImage(carteGareCouleur);
                    }

                    if (Objects.equals(couleurJ5Francais, "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                        Image avatarRouge = new Image("images/avatar-ROUGE.png");

                        vueFinPartie.getImageJoueur5().setImage(avatarRouge);

                        Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                        vueFinPartie.getImagewagonj5().setImage(cartewagonCouleur);

                        Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                        vueFinPartie.getImagegarej5().setImage(carteGareCouleur);
                    }

                    vueFinPartie.getCadreJoueur5().setStyle(couleur);
                }

            }

            for (IJoueur joueur : jeu.getJoueurs()) {


                if (Objects.equals(joueur.getNom(), vueFinPartie.getNomJoueur1().getText())) {
                    int nbgareJ1 = joueur.getNbGares();
                    String nbGareJ1String = String.valueOf(nbgareJ1);

                    vueFinPartie.getNbgarej1().setText(nbGareJ1String);

                    int nbwagonj1 = joueur.getNbWagons();
                    String nbwagonj1String = String.valueOf(nbwagonj1);


                    vueFinPartie.getNbwagonj1().setText(nbwagonj1String);

                    int nbPointj1 = joueur.getScore();
                    String nbPointj1String = String.valueOf(nbPointj1);

                    vueFinPartie.getPointJ1().setText(nbPointj1String);
                }

                if (Objects.equals(joueur.getNom(), vueFinPartie.getNomJoueur2().getText())) {

                    int nbgareJ2 = joueur.getNbGares();
                    String nbGareJ2String = String.valueOf(nbgareJ2);

                    vueFinPartie.getNbgarej2().setText(nbGareJ2String);

                    int nbwagonj2 = joueur.getNbWagons();
                    String nbwagonj2String = String.valueOf(nbwagonj2);


                    vueFinPartie.getNbwagonj2().setText(nbwagonj2String);

                    int nbPointj2 = joueur.getScore();
                    String nbPointj2String = String.valueOf(nbPointj2);

                    vueFinPartie.getPointJ2().setText(nbPointj2String);
                }

                if (Objects.equals(joueur.getNom(), vueFinPartie.getNomJoueur3().getText())) {

                    int nbgareJ3 = joueur.getNbGares();
                    String nbGareJ3String = String.valueOf(nbgareJ3);

                    vueFinPartie.getNbgarej3().setText(nbGareJ3String);

                    int nbwagonj3 = joueur.getNbWagons();
                    String nbwagonj3String = String.valueOf(nbwagonj3);


                    vueFinPartie.getNbwagonj3().setText(nbwagonj3String);

                    int nbPointj3 = joueur.getScore();
                    String nbPointj3String = String.valueOf(nbPointj3);

                    vueFinPartie.getPointJ3().setText(nbPointj3String);
                }

                if (Objects.equals(joueur.getNom(), vueFinPartie.getNomJoueur4().getText())) {

                    int nbgareJ4 = joueur.getNbGares();
                    String nbGareJ4String = String.valueOf(nbgareJ4);

                    vueFinPartie.getNbgarej4().setText(nbGareJ4String);

                    int nbwagonj4 = joueur.getNbWagons();
                    String nbwagonj4String = String.valueOf(nbwagonj4);


                    vueFinPartie.getNbwagonj4().setText(nbwagonj4String);

                    int nbPointj4 = joueur.getScore();
                    String nbPointj4String = String.valueOf(nbPointj4);

                    vueFinPartie.getPointJ4().setText(nbPointj4String);



                }

                if (Objects.equals(joueur.getNom(), vueFinPartie.getNomJoueur5().getText())) {


                    int nbgareJ5 = joueur.getNbGares();
                    String nbGareJ5String = String.valueOf(nbgareJ5);

                    vueFinPartie.getNbgarej5().setText(nbGareJ5String);

                    int nbwagonj5 = joueur.getNbWagons();
                    String nbwagonj5String = String.valueOf(nbwagonj5);


                    vueFinPartie.getNbwagonj5().setText(nbwagonj5String);

                    int nbPointj5 = joueur.getScore();
                    String nbPointj5String = String.valueOf(nbPointj5);

                    vueFinPartie.getPointJ5().setText(nbPointj5String);
                }
            }




            if (Objects.equals(vueFinPartie.getNomJoueur1().getText(), "")) {
                vueFinPartie.getCadreJoueur1().setStyle("-fx-opacity:0;");
                vueFinPartie.getPointJ1().setText("");

            }
            if (Objects.equals(vueFinPartie.getNomJoueur2().getText(), "")) {
                vueFinPartie.getCadreJoueur2().setStyle("-fx-opacity:0;");
                vueFinPartie.getPointJ2().setText("");

            }
            if (Objects.equals(vueFinPartie.getNomJoueur3().getText(), "")) {
                vueFinPartie.getCadreJoueur3().setStyle("-fx-opacity:0;");
                vueFinPartie.getPointJ3().setText("");

            }

            if (Objects.equals(vueFinPartie.getNomJoueur4().getText(), "")) {
                vueFinPartie.getCadreJoueur4().setStyle("-fx-opacity:0;");
                vueFinPartie.getPointJ4().setText("");
            }

            if (Objects.equals(vueFinPartie.getNomJoueur5().getText(), "")) {
                vueFinPartie.getCadreJoueur5().setStyle("-fx-opacity:0;");
                vueFinPartie.getPointJ5().setText("");
            }


            Scene scene = new Scene(vueFinPartie);

            stageFinPartie.setTitle("Fin de partie");
            stageFinPartie.setScene(scene);
            stageFinPartie.show();
        }

    };



    public IJeu getJeu() {
        return jeu;
    }

    EventHandler<ActionEvent> boutonCLique = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

            jeu.passerAEteChoisi();
            compteurTour++;

        }
    };





    public void creerBindings() {
        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();


        instructionCourante.textProperty().bind(this.getJeu().instructionProperty());
        vueCarteVisibleJava.creerBindings();
        vueJoueurCourantJava.creerBindings();
        vueAutresJoueurs.creerBindings();
        boutonPasser.setOnAction(boutonCLique);
        vuePlateau.CreerBindings();

        boutonTerminer.setOnAction(boutonRegleClique);

    }


}
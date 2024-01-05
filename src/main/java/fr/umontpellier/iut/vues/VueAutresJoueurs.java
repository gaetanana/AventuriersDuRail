package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.IVille;
import fr.umontpellier.iut.rails.Joueur;
import javafx.application .Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

//import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Cette classe présente les éléments des joueurs autres que le joueur courant,
 * en cachant ceux que le joueur courant n'a pas à connaitre.
 * <p>
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueAutresJoueurs extends VBox {

    private IJeu jeu;

    @FXML
    private VBox vueAutreJoueur;

    @FXML
    private VBox cadreJoueur1;
    @FXML
    private VBox cadreJoueur2;
    @FXML
    private VBox cadreJoueur3;
    @FXML
    private VBox cadreJoueur4;
    @FXML
    private VBox cadreJoueur5;

    @FXML
    private Label nomJoueur1;
    @FXML
    private Label nomJoueur2;
    @FXML
    private Label nomJoueur3;
    @FXML
    private Label nomJoueur4;
    @FXML
    private Label nomJoueur5;

    @FXML
    private ImageView imageJoueur1;
    @FXML
    private ImageView imageJoueur2;
    @FXML
    private ImageView imageJoueur3;
    @FXML
    private ImageView imageJoueur4;
    @FXML
    private ImageView imageJoueur5;

    @FXML
    private Label pointJ1;
    @FXML
    private Label pointJ2;
    @FXML
    private Label pointJ3;
    @FXML
    private Label pointJ4;
    @FXML
    private Label pointJ5;


    @FXML
    private ImageView imagegarej1;
    @FXML
    private ImageView imagegarej2;
    @FXML
    private ImageView imagegarej3;
    @FXML
    private ImageView imagegarej4;
    @FXML
    private ImageView imagegarej5;

    @FXML
    private Label nbgarej1;
    @FXML
    private Label nbgarej2;
    @FXML
    private Label nbgarej3;
    @FXML
    private Label nbgarej4;
    @FXML
    private Label nbgarej5;

    @FXML
    private ImageView imagewagonj1;
    @FXML
    private ImageView imagewagonj2;
    @FXML
    private ImageView imagewagonj3;
    @FXML
    private ImageView imagewagonj4;
    @FXML
    private ImageView imagewagonj5;

    @FXML
    private Label nbwagonj1;
    @FXML
    private Label nbwagonj2;
    @FXML
    private Label nbwagonj3;
    @FXML
    private Label nbwagonj4;
    @FXML
    private Label nbwagonj5;


    public VueAutresJoueurs() {

        try {
            FXMLLoader loaderVueJoueur = new FXMLLoader(getClass().getClassLoader().getResource("fxml/vueAutreJoueur.fxml"));
            loaderVueJoueur.setRoot(this);
            loaderVueJoueur.setController(this);
            loaderVueJoueur.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void creerBindings() {

        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();


        List<String> nomJoueurTempo = new ArrayList<>();

        for (Joueur joueur : iJeu.getJoueurs()) {
            nomJoueurTempo.add(joueur.getNom());
        }

        while (!nomJoueurTempo.isEmpty()) {
            String nom = nomJoueurTempo.remove(0);

            if (Objects.equals(nomJoueur1.getText(), "")) {
                nomJoueur1.setText(nom);
                String couleurJ1Francais = "";
                for (Joueur joueur : iJeu.getJoueurs()) {
                    if (Objects.equals(joueur.getNom(), nom)) {
                        couleurJ1Francais = joueur.getCouleur().toString();
                    }
                }

                String couleur = "";
                if (Objects.equals(couleurJ1Francais, "VERT")) {
                    couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";
                    Image avatarVert = new Image("images/avatar-VERT.png");

                    imageJoueur1.setImage(avatarVert);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                    imagewagonj1.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                    imagegarej1.setImage(carteGareCouleur);


                }

                if (Objects.equals(couleurJ1Francais, "ROSE")) {
                    couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";
                    Image avatarRose = new Image("images/AVATAR-ROSE.png");
                    imageJoueur1.setImage(avatarRose);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                    imagewagonj1.setImage(carteWagonCouleur);


                    Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                    imagegarej1.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ1Francais, "BLEU")) {
                    couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";
                    Image avatarBleu = new Image("images/avatar-BLEU.png");
                    imageJoueur1.setImage(avatarBleu);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                    imagewagonj1.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                    imagegarej1.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ1Francais, "JAUNE")) {
                    couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";
                    Image avatarJaune = new Image("images/avatar-JAUNE.png");
                    imageJoueur1.setImage(avatarJaune);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                    imagewagonj1.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                    imagegarej1.setImage(carteGareCouleur);

                }

                if (Objects.equals(couleurJ1Francais, "ROUGE")) {
                    couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";
                    Image avatarRouge = new Image("images/avatar-ROUGE.png");
                    imageJoueur1.setImage(avatarRouge);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                    imagewagonj1.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                    imagegarej1.setImage(carteGareCouleur);
                }

                cadreJoueur1.setStyle(couleur);
            } else if (Objects.equals(nomJoueur2.getText(), "")) {
                nomJoueur2.setText(nom);

                String couleurJ2Francais = "";
                for (Joueur joueur : iJeu.getJoueurs()) {
                    if (Objects.equals(joueur.getNom(), nom)) {
                        couleurJ2Francais = joueur.getCouleur().toString();
                    }
                }

                String couleur = "";

                if (Objects.equals(couleurJ2Francais, "VERT")) {
                    couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                    Image avatarVert = new Image("images/avatar-VERT.png");

                    imageJoueur2.setImage(avatarVert);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                    imagewagonj2.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                    imagegarej2.setImage(carteGareCouleur);


                }

                if (Objects.equals(couleurJ2Francais, "ROSE")) {
                    couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                    Image avatarRose = new Image("images/AVATAR-ROSE.png");

                    imageJoueur2.setImage(avatarRose);

                    Image carteWagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                    imagewagonj2.setImage(carteWagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                    imagegarej2.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ2Francais, "BLEU")) {
                    couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                    Image avatarBleu = new Image("images/avatar-BLEU.png");

                    imageJoueur2.setImage(avatarBleu);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                    imagewagonj2.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                    imagegarej2.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ2Francais, "JAUNE")) {
                    couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                    Image avatarJaune = new Image("images/avatar-JAUNE.png");
                    imageJoueur2.setImage(avatarJaune);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                    imagewagonj2.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                    imagegarej2.setImage(carteGareCouleur);

                }

                if (Objects.equals(couleurJ2Francais, "ROUGE")) {
                    couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                    Image avatarRouge = new Image("images/avatar-ROUGE.png");

                    imageJoueur2.setImage(avatarRouge);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                    imagewagonj2.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                    imagegarej2.setImage(carteGareCouleur);

                }

                cadreJoueur2.setStyle(couleur);


            } else if (Objects.equals(nomJoueur3.getText(), "")) {
                nomJoueur3.setText(nom);

                String couleurJ3Francais = "";
                for (Joueur joueur : iJeu.getJoueurs()) {
                    if (Objects.equals(joueur.getNom(), nom)) {
                        couleurJ3Francais = joueur.getCouleur().toString();
                    }
                }

                String couleur = "";

                if (Objects.equals(couleurJ3Francais, "VERT")) {
                    couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                    Image avatarVert = new Image("images/avatar-VERT.png");

                    imageJoueur3.setImage(avatarVert);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                    imagewagonj3.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                    imagegarej3.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ3Francais, "ROSE")) {
                    couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                    Image avatarRose = new Image("images/AVATAR-ROSE.png");

                    imageJoueur3.setImage(avatarRose);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                    imagewagonj3.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                    imagegarej3.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ3Francais, "BLEU")) {
                    couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";
                    Image avatarBleu = new Image("images/avatar-BLEU.png");

                    imageJoueur3.setImage(avatarBleu);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                    imagewagonj3.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                    imagegarej3.setImage(carteGareCouleur);

                }

                if (Objects.equals(couleurJ3Francais, "JAUNE")) {
                    couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                    Image avatarJaune = new Image("images/avatar-JAUNE.png");

                    imageJoueur3.setImage(avatarJaune);


                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                    imagewagonj3.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                    imagegarej3.setImage(carteGareCouleur);

                }

                if (Objects.equals(couleurJ3Francais, "ROUGE")) {
                    couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                    Image avatarRouge = new Image("images/avatar-ROUGE.png");

                    imageJoueur3.setImage(avatarRouge);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                    imagewagonj3.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                    imagegarej3.setImage(carteGareCouleur);
                }

                cadreJoueur3.setStyle(couleur);
            } else if (Objects.equals(nomJoueur4.getText(), "")) {
                nomJoueur4.setText(nom);

                String couleurJ4Francais = "";
                for (Joueur joueur : iJeu.getJoueurs()) {
                    if (Objects.equals(joueur.getNom(), nom)) {
                        couleurJ4Francais = joueur.getCouleur().toString();
                    }
                }

                String couleur = "";

                if (Objects.equals(couleurJ4Francais, "VERT")) {
                    couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                    Image avatarVert = new Image("images/avatar-VERT.png");

                    imageJoueur4.setImage(avatarVert);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                    imagewagonj4.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                    imagegarej4.setImage(carteGareCouleur);

                }

                if (Objects.equals(couleurJ4Francais, "ROSE")) {
                    couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                    Image avatarRose = new Image("images/AVATAR-ROSE.png");

                    imageJoueur4.setImage(avatarRose);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                    imagewagonj4.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                    imagegarej4.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ4Francais, "BLEU")) {
                    couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                    Image avatarBleu = new Image("images/avatar-BLEU.png");

                    imageJoueur4.setImage(avatarBleu);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                    imagewagonj4.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                    imagegarej4.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ4Francais, "JAUNE")) {
                    couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                    Image avatarJaune = new Image("images/avatar-JAUNE.png");

                    imageJoueur4.setImage(avatarJaune);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                    imagewagonj4.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                    imagegarej4.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ4Francais, "ROUGE")) {
                    couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                    Image avatarRouge = new Image("images/avatar-ROUGE.png");

                    imageJoueur4.setImage(avatarRouge);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                    imagewagonj4.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                    imagegarej4.setImage(carteGareCouleur);
                }

                cadreJoueur4.setStyle(couleur);

            } else if (Objects.equals(nomJoueur5.getText(), "")) {
                nomJoueur5.setText(nom);

                String couleurJ5Francais = "";
                for (Joueur joueur : iJeu.getJoueurs()) {
                    if (Objects.equals(joueur.getNom(), nom)) {
                        couleurJ5Francais = joueur.getCouleur().toString();
                    }
                }

                String couleur = "";

                if (Objects.equals(couleurJ5Francais, "VERT")) {
                    couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";

                    Image avatarVert = new Image("images/avatar-VERT.png");

                    imageJoueur5.setImage(avatarVert);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-VERT.png");
                    imagewagonj5.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-VERT.png");
                    imagegarej5.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ5Francais, "ROSE")) {
                    couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";

                    Image avatarRose = new Image("images/AVATAR-ROSE.png");

                    imageJoueur5.setImage(avatarRose);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROSE.png");
                    imagewagonj5.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROSE.png");
                    imagegarej5.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ5Francais, "BLEU")) {
                    couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";

                    Image avatarBleu = new Image("images/avatar-BLEU.png");

                    imageJoueur5.setImage(avatarBleu);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-BLEU.png");
                    imagewagonj5.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-BLEU.png");
                    imagegarej5.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ5Francais, "JAUNE")) {
                    couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";

                    Image avatarJaune = new Image("images/avatar-JAUNE.png");

                    imageJoueur5.setImage(avatarJaune);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-JAUNE.png");
                    imagewagonj5.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-JAUNE.png");
                    imagegarej5.setImage(carteGareCouleur);
                }

                if (Objects.equals(couleurJ5Francais, "ROUGE")) {
                    couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";

                    Image avatarRouge = new Image("images/avatar-ROUGE.png");

                    imageJoueur5.setImage(avatarRouge);

                    Image cartewagonCouleur = new Image("images/wagons/image-wagon-ROUGE.png");
                    imagewagonj5.setImage(cartewagonCouleur);

                    Image carteGareCouleur = new Image("images/gares/gare-ROUGE.png");
                    imagegarej5.setImage(carteGareCouleur);
                }

                cadreJoueur5.setStyle(couleur);
            }

        }

        for (IJoueur joueur : ((VueDuJeu) getScene().getRoot()).getJeu().getJoueurs()) {
            System.out.println("joueur : " + joueur.getNom());
            if (Objects.equals(joueur.getNom(), nomJoueur1.getText())) {
                nbgarej1.setText("3");
                nbwagonj1.setText("45");
                pointJ1.setText("12");
            }

            if (Objects.equals(joueur.getNom(), nomJoueur2.getText())) {
                nbgarej2.setText("3");
                nbwagonj2.setText("45");
                pointJ2.setText("12");
            }

            if (Objects.equals(joueur.getNom(), nomJoueur3.getText())) {
                nbgarej3.setText("3");
                nbwagonj3.setText("45");
                pointJ3.setText("12");
            }

            if (Objects.equals(joueur.getNom(), nomJoueur4.getText())) {
                nbgarej4.setText("3");
                nbwagonj4.setText("45");
                pointJ4.setText("12");
            }

            if (Objects.equals(joueur.getNom(), nomJoueur5.getText())) {
                nbgarej5.setText("3");
                nbwagonj5.setText("45");
                pointJ5.setText("12");
            }
        }


        if (Objects.equals(nomJoueur1.getText(), "")) {
            cadreJoueur1.setStyle("-fx-opacity:0;");
            pointJ1.setText("");
        }
        if (Objects.equals(nomJoueur2.getText(), "")) {
            cadreJoueur2.setStyle("-fx-opacity:0;");
            pointJ2.setText("");
        }
        if (Objects.equals(nomJoueur3.getText(), "")) {
            cadreJoueur3.setStyle("-fx-opacity:0;");

        }

        if (Objects.equals(nomJoueur4.getText(), "")) {
            cadreJoueur4.setStyle("-fx-opacity:0;");
        }

        if (Objects.equals(nomJoueur5.getText(), "")) {
            cadreJoueur5.setStyle("-fx-opacity:0;");
        }


        ChangeListener<IJoueur> changementScore = new ChangeListener<IJoueur>() {
            @Override
            public void changed(ObservableValue<? extends IJoueur> observableValue, IJoueur iJoueur, IJoueur t1) {
                Platform.runLater(() -> {


                    if (iJoueur != null) {
                        int scoreJoueurActuel = iJoueur.getScore();
                        int nombreDeGareJoueurActuel = iJoueur.getNbGares();
                        int nombreDeWagon = iJoueur.getNbWagons();

                        String scoreEnString = String.valueOf(scoreJoueurActuel);
                        String nbGareEnString = String.valueOf(nombreDeGareJoueurActuel);
                        String nbWagonEnString = String.valueOf(nombreDeWagon);


                        if (Objects.equals(nomJoueur1.getText(), iJoueur.getNom())) {

                            pointJ1.setText(scoreEnString);
                            nbgarej1.setText(nbGareEnString);
                            nbwagonj1.setText(nbWagonEnString);


                        }

                        if (Objects.equals(nomJoueur2.getText(), iJoueur.getNom())) {
                            pointJ2.setText(scoreEnString);
                            nbgarej2.setText(nbGareEnString);
                            nbwagonj2.setText(nbWagonEnString);

                        }

                        if (Objects.equals(nomJoueur3.getText(), iJoueur.getNom())) {
                            pointJ3.setText(scoreEnString);
                            nbgarej3.setText(nbGareEnString);
                            nbwagonj3.setText(nbWagonEnString);


                        }

                        if (Objects.equals(nomJoueur4.getText(), iJoueur.getNom())) {
                            pointJ4.setText(scoreEnString);
                            nbgarej4.setText(nbGareEnString);
                            nbwagonj4.setText(nbWagonEnString);

                        }
                        if (Objects.equals(nomJoueur5.getText(), iJoueur.getNom())) {
                            pointJ5.setText(scoreEnString);
                            nbgarej5.setText(nbGareEnString);
                            nbwagonj5.setText(nbWagonEnString);
                        }
                    }
                });
            }
        };

        iJeu.joueurCourantProperty().addListener(changementScore);

    }


}

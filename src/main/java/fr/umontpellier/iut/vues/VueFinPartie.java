package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.rails.Joueur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VueFinPartie extends HBox {



    @FXML public VBox cadreJoueur1;
    @FXML public VBox cadreJoueur2;
    @FXML public VBox cadreJoueur3;
    @FXML public VBox cadreJoueur4;
    @FXML public VBox cadreJoueur5;

    public VBox getCadreJoueur1() {
        return cadreJoueur1;
    }

    public VBox getCadreJoueur2() {
        return cadreJoueur2;
    }

    public VBox getCadreJoueur3() {
        return cadreJoueur3;
    }

    public VBox getCadreJoueur4() {
        return cadreJoueur4;
    }

    public VBox getCadreJoueur5() {
        return cadreJoueur5;
    }

    @FXML public Label nomJoueur1;
    @FXML public Label nomJoueur2;
    @FXML public Label nomJoueur3;
    @FXML public Label nomJoueur4;
    @FXML public Label nomJoueur5;

    public Label getNomJoueur1() {
        return nomJoueur1;
    }

    public Label getNomJoueur2() {
        return nomJoueur2;
    }

    public Label getNomJoueur3() {
        return nomJoueur3;
    }

    public Label getNomJoueur4() {
        return nomJoueur4;
    }

    public Label getNomJoueur5() {
        return nomJoueur5;
    }

    public ImageView getImageJoueur1() {
        return imageJoueur1;
    }

    public ImageView getImageJoueur2() {
        return imageJoueur2;
    }

    public ImageView getImageJoueur3() {
        return imageJoueur3;
    }

    public ImageView getImageJoueur4() {
        return imageJoueur4;
    }

    public ImageView getImageJoueur5() {
        return imageJoueur5;
    }

    public Label getPointJ1() {
        return pointJ1;
    }

    public Label getPointJ2() {
        return pointJ2;
    }

    public Label getPointJ3() {
        return pointJ3;
    }

    public Label getPointJ4() {
        return pointJ4;
    }

    public Label getPointJ5() {
        return pointJ5;
    }

    public ImageView getImagegarej1() {
        return imagegarej1;
    }

    public ImageView getImagegarej2() {
        return imagegarej2;
    }

    public ImageView getImagegarej3() {
        return imagegarej3;
    }

    public ImageView getImagegarej4() {
        return imagegarej4;
    }

    public ImageView getImagegarej5() {
        return imagegarej5;
    }

    public Label getNbgarej1() {
        return nbgarej1;
    }

    public Label getNbgarej2() {
        return nbgarej2;
    }

    public Label getNbgarej3() {
        return nbgarej3;
    }

    public Label getNbgarej4() {
        return nbgarej4;
    }

    public Label getNbgarej5() {
        return nbgarej5;
    }

    public ImageView getImagewagonj1() {
        return imagewagonj1;
    }

    public ImageView getImagewagonj2() {
        return imagewagonj2;
    }

    public ImageView getImagewagonj3() {
        return imagewagonj3;
    }

    public ImageView getImagewagonj4() {
        return imagewagonj4;
    }

    public ImageView getImagewagonj5() {
        return imagewagonj5;
    }

    public Label getNbwagonj1() {
        return nbwagonj1;
    }

    public Label getNbwagonj2() {
        return nbwagonj2;
    }

    public Label getNbwagonj3() {
        return nbwagonj3;
    }

    public Label getNbwagonj4() {
        return nbwagonj4;
    }

    public Label getNbwagonj5() {
        return nbwagonj5;
    }

    @FXML public ImageView imageJoueur1;
    @FXML public ImageView imageJoueur2;
    @FXML public ImageView imageJoueur3;
    @FXML public ImageView imageJoueur4;
    @FXML public ImageView imageJoueur5;

    @FXML public Label pointJ1;
    @FXML public Label pointJ2;
    @FXML public Label pointJ3;
    @FXML public Label pointJ4;
    @FXML public Label pointJ5;



    @FXML public ImageView imagegarej1;
    @FXML public ImageView imagegarej2;
    @FXML public ImageView imagegarej3;
    @FXML public ImageView imagegarej4;
    @FXML public ImageView imagegarej5;

    @FXML public Label nbgarej1;
    @FXML public Label nbgarej2;
    @FXML public Label nbgarej3;
    @FXML public Label nbgarej4;
    @FXML public Label nbgarej5;

    @FXML public ImageView imagewagonj1;
    @FXML public ImageView imagewagonj2;
    @FXML public ImageView imagewagonj3;
    @FXML public ImageView imagewagonj4;
    @FXML public ImageView imagewagonj5;

    @FXML public Label nbwagonj1;
    @FXML public Label nbwagonj2;
    @FXML public Label nbwagonj3;
    @FXML public Label nbwagonj4;
    @FXML public Label nbwagonj5;









    public VueFinPartie(){

        try {
            FXMLLoader loaderCarte = new FXMLLoader(getClass().getClassLoader().getResource("fxml/vueFinJeu.fxml"));
            loaderCarte.setRoot(this);
            loaderCarte.setController(this);
            loaderCarte.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void creerBindings() {

        /* iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();


        List<String> nomJoueurTempo = new ArrayList<>();

        for (Joueur joueur : iJeu.getJoueurs()) {
            nomJoueurTempo.add(joueur.getNom());

            System.out.println(joueur);
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
        */
    }




}

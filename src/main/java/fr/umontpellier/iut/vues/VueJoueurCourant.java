package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.ICouleurWagon;
import fr.umontpellier.iut.IDestination;
import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.rails.CouleurWagon;
import fr.umontpellier.iut.rails.Destination;
import fr.umontpellier.iut.rails.Joueur;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.Objects;

/**
 * Cette classe présente les éléments appartenant au joueur courant.
 * <p>
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueJoueurCourant extends HBox {

    @FXML
    private Label labelNomJoueur;

    @FXML
    private HBox HBoxVuejoueurCourant;

    @FXML
    private HBox carteJoueurCourant;
    @FXML
    private HBox carteDestinationJoueurCourant;



    private VueDestination vueDestination;
    private VueCarteWagon carteWagonJoueur;
    private VuePlateau plateau;


    private int compteur;
    public VueJoueurCourant() {

        try {
            FXMLLoader loaderCarte = new FXMLLoader(getClass().getClassLoader().getResource("fxml/vueJoueurCourant.fxml"));
            loaderCarte.setRoot(this);
            loaderCarte.setController(this);
            loaderCarte.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        compteur = 0;
    }




    public VueDestination trouverLabelDestination(IDestination destination) {
        for (Node node : carteDestinationJoueurCourant.getChildren()) {
            VueDestination c = (VueDestination) node;
            if (c.getDestination().equals(destination)) {
                return c;
            }
        }
        return null;

    }




    public void creerBindings() {
        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();

        ListChangeListener<IDestination> destinationListChangeListener = new ListChangeListener<IDestination>() {
            @Override
            public void onChanged(Change<? extends IDestination> change) {
                Platform.runLater(() -> {


                    while (change.next()) {
                        if (change.wasAdded()) {

                            for (IDestination d : change.getAddedSubList()) {

                                vueDestination = new VueDestination(d);


                                vueDestination.creeBinding();


                                carteDestinationJoueurCourant.getChildren().add(vueDestination);
                            }
                        } else if (change.wasRemoved()) {
                            for (IDestination d : change.getRemoved()) {
                                //System.out.println(d.getNom() + " enlevé");
                                carteDestinationJoueurCourant.getChildren().remove(trouverLabelDestination(d));
                            }
                        }
                    }
                });

            }
        };

        iJeu.destinationsInitialesProperty().addListener(destinationListChangeListener);

        ChangeListener<IJoueur> listChangeListener = new ChangeListener<IJoueur>() {

            @Override
            public void changed(ObservableValue<? extends IJoueur> observableValue, IJoueur iJoueur, IJoueur t1) {
                Platform.runLater(() -> {

                    labelNomJoueur.setText(t1.getNom());
                    String couleur = "";


                    if (Objects.equals(t1.getCouleur().toString(), "VERT")) {
                        couleur += "-fx-background-color:lightgreen;" + "-fx-background-radius:15;";
                        compteur++;
                    }

                    if (Objects.equals(t1.getCouleur().toString(), "ROSE")) {
                        couleur += "-fx-background-color:pink;" + "-fx-background-radius:15;";
                        compteur++;
                    }

                    if (Objects.equals(t1.getCouleur().toString(), "BLEU")) {
                        couleur += "-fx-background-color:lightblue;" + "-fx-background-radius:15;";
                        compteur++;
                    }

                    if (Objects.equals(t1.getCouleur().toString(), "JAUNE")) {
                        couleur += "-fx-background-color:khaki;" + "-fx-background-radius:15;";
                        compteur++;
                    }

                    if (Objects.equals(t1.getCouleur().toString(), "ROUGE")) {
                        couleur += "-fx-background-color: crimson;" + "-fx-background-radius:15;";
                        compteur++;
                    }


                    HBoxVuejoueurCourant.setStyle(couleur);


                    carteJoueurCourant.getChildren().clear();
                    carteDestinationJoueurCourant.getChildren().clear();

                    for (ICouleurWagon couleurWagon : t1.getCartesWagon()) {
                        carteWagonJoueur = new VueCarteWagon(couleurWagon);
                        carteWagonJoueur.creeBinding();
                        carteJoueurCourant.getChildren().add(carteWagonJoueur);

                    }

                    for (IDestination destinations : t1.getDestinations()) {
                        vueDestination = new VueDestination(destinations);
                        vueDestination.voirLabel();
                        carteDestinationJoueurCourant.getChildren().add(vueDestination);
                    }

                    Label d = ((VueDuJeu) getScene().getRoot()).getTour();




                    String c = String.valueOf(compteur);

                    d.setText(c);



                });
            }
        };


        iJeu.joueurCourantProperty().addListener(listChangeListener);

    }
}

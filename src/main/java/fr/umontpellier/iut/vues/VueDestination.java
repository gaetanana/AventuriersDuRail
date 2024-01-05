package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.IDestination;
import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.rails.Destination;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe représente la vue d'une carte Destination.
 * <p>
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueDestination extends Pane {

    private IDestination destination;
    VueJoueurCourant vueJoueurCourant;


    public VueDestination(IDestination destination) {


        //System.out.println("nom destination "+destination.getNom());

        this.destination = destination;
        String nomDestinationAvecValeur = destination.getNom();
        String[] f = nomDestinationAvecValeur.split(" ");

        String url = "images/missions/eu-" + f[0].toLowerCase() + "-" + f[2].toLowerCase() + ".png";

        //System.out.println(url);

        Image image = new Image(url);
        ImageView imageView = new ImageView(image);


        vueJoueurCourant = new VueJoueurCourant();

        getChildren().add(imageView);


    }

    public IDestination getDestination() {
        return destination;
    }

    public void creeBinding() {

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ((VueDuJeu) getScene().getRoot()).getJeu().uneDestinationAEteChoisie(destination.getNom());
            }
        });

        this.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {





                ((VueDuJeu) getScene().getRoot()).getLabelDestination().setText(destination.getNom());
                //((VueJoueurCourant) getScene().getRoot()).getLabelDestination().setText(destination.getNom());


            }
        });

    }

    public void voirLabel() {


        this.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {




                ((VueDuJeu) getScene().getRoot()).getLabelDestination().setText(destination.getNom());



            }
        });

    }
}

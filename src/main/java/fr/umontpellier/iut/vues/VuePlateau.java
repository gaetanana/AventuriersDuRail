package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.IJeu;
import fr.umontpellier.iut.IJoueur;
import fr.umontpellier.iut.IRoute;
import fr.umontpellier.iut.IVille;
import fr.umontpellier.iut.rails.Ferry;
import fr.umontpellier.iut.rails.Route;
import fr.umontpellier.iut.rails.Tunnel;
import fr.umontpellier.iut.rails.Ville;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.event.ChangeEvent;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cette classe présente les routes et les villes sur le plateau.
 * <p>
 * On y définit le listener à exécuter lorsque qu'un élément du plateau a été choisi par l'utilisateur
 * ainsi que les bindings qui mettront ?à jour le plateau après la prise d'une route ou d'une ville par un joueur
 */
public class VuePlateau extends Pane {

    @FXML
    private Group routes2;

    @FXML
    private Group villes2;



    public VuePlateau() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/plateau.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void CreerBindings() {

        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();


        ChangeListener<IJoueur> listenerVille = new ChangeListener<IJoueur>() {
            //Pour les routes j'aurais deux boubcles nodes
            //
            @Override
            public void changed(ObservableValue<? extends IJoueur> observableValue, IJoueur iJoueur, IJoueur t1) {
                Platform.runLater(() -> {

                    for (Node ville:villes2.getChildren()) {

                        ville = (Circle) ville;
                        for (Object villeJeu :iJeu.getVilles()) {
                            villeJeu = (IVille) villeJeu;
                            if(ville.getId().equals(((IVille) villeJeu).getNom()) ){

                                if(((IVille) villeJeu).getProprietaire() != null &&((IVille) villeJeu).getProprietaire().equals(t1)){

                                    if(t1.getCouleur().equals(IJoueur.Couleur.ROUGE)){
                                        ((Circle) ville).setStyle("-fx-fill:CRIMSON");

                                    }
                                    else if(t1.getCouleur().equals(IJoueur.Couleur.VERT)){
                                        ((Circle) ville).setStyle("-fx-fill:LIGHTGREEN");
                                    }
                                    else if(t1.getCouleur().equals(IJoueur.Couleur.ROSE)){
                                        ((Circle) ville).setStyle("-fx-fill:PINK");

                                    }
                                    else if(t1.getCouleur().equals(IJoueur.Couleur.BLEU)){
                                        ((Circle) ville).setStyle("-fx-fill:LIGHTBLUE");

                                    }
                                    else if(t1.getCouleur().equals(IJoueur.Couleur.JAUNE)){
                                        ((Circle) ville).setStyle("-fx-fill:KHAKI");

                                    }

                                }
                            }
                        }

                    }

                });
            }
        };


        ChangeListener<IJoueur> listenerRoute = new ChangeListener<IJoueur>() {
            //Pour les routes j'aurais deux boubcles nodes

            @Override
            public void changed(ObservableValue<? extends IJoueur> observableValue, IJoueur iJoueur, IJoueur t1) {
                Platform.runLater(() -> {

                    for (Node route:routes2.getChildren()) {
                        //System.out.println(route.getId());

                        for (Node route2:((Group) route).getChildren()) {

                            route2 = (Rectangle) route2;

                            for (Object routeJeu :iJeu.getRoutes()) {
                                routeJeu = (IRoute) routeJeu;
                                if(route.getId().equals(((IRoute) routeJeu).getNom()) ){

                                    if(((IRoute) routeJeu).getProprietaire() != null &&((IRoute) routeJeu).getProprietaire().equals(t1)){

                                        if(t1.getCouleur().equals(IJoueur.Couleur.ROUGE)){
                                            ((Rectangle) route2).setStyle("-fx-fill:CRIMSON");

                                        }
                                        else if(t1.getCouleur().equals(IJoueur.Couleur.VERT)){
                                            ((Rectangle) route2).setStyle("-fx-fill:LIGHTGREEN");
                                            System.out.println("je rentre ici" + t1.getNom());

                                        }
                                        else if(t1.getCouleur().equals(IJoueur.Couleur.ROSE)){
                                            ((Rectangle) route2).setStyle("-fx-fill:PINK");

                                        }
                                        else if(t1.getCouleur().equals(IJoueur.Couleur.BLEU)){
                                            ((Rectangle) route2).setStyle("-fx-fill:LIGHTBLUE");

                                        }
                                        else if(t1.getCouleur().equals(IJoueur.Couleur.JAUNE)){
                                            ((Rectangle) route2).setStyle("-fx-fill:KHAKI");
                                        }

                                    }
                                }
                            }
                        }


                    }

                });
            }
        };




        for (Object ville : ((VueDuJeu) getScene().getRoot()).getJeu().getVilles()){
            ville = (IVille) ville;
            ((IVille) ville).proprietaireProperty().addListener(listenerVille);
        }


        for (Object route : ((VueDuJeu) getScene().getRoot()).getJeu().getRoutes()){
            route = (IRoute) route;
            ((IRoute) route).proprietaireProperty().addListener(listenerRoute);
        }

        //iJeu.joueurCourantProperty().addListener(listenerRoute);
        //iJeu.joueurCourantProperty().addListener(listenerVille);

    }


    @FXML
    public void choixRouteOuVille(Event event) {

        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();
        String selection = ((Node) event.getSource()).getId();
        iJeu.uneVilleOuUneRouteAEteChoisie(selection);


    }
}

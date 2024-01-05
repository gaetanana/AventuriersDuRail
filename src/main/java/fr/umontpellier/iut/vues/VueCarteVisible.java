package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.ICouleurWagon;
import fr.umontpellier.iut.IJeu;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javafx.event.Event;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class VueCarteVisible extends VBox {

    @FXML
    private VBox carteVisible;

    @FXML
    private ImageView piocheCarteWagon;
    @FXML
    private ImageView piocheCarteDestination;

    VueCarteWagon vueCarteWagon;

    public VueCarteVisible() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/vueCarteVisible.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public VueCarteWagon trouverCarte(ICouleurWagon ca) {
        for (Node node : carteVisible.getChildren()) {
            VueCarteWagon c = (VueCarteWagon) node;
            if (c.getCouleurWagon().equals(ca)) {
                return c;
            }
        }
        return null;
    }


    public void creerBindings() {

        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();


        ListChangeListener<ICouleurWagon> changeListener = new ListChangeListener<ICouleurWagon>() {

            @Override
            public void onChanged(Change<? extends ICouleurWagon> change) {
                Platform.runLater(() -> {
                    while (change.next()) {

                        if (change.wasAdded()) {
                            for (ICouleurWagon carteWagon : change.getAddedSubList()) {

                                vueCarteWagon = new VueCarteWagon(carteWagon);
                                vueCarteWagon.creeBinding();
                                carteVisible.getChildren().add(vueCarteWagon);


                            }

                        } else if (change.wasRemoved()) {
                            for (int i = 0; i < change.getRemoved().size(); i++) {
                                carteVisible.getChildren().remove(trouverCarte(change.getRemoved().get(i)));
                            }
                        }

                    }
                });

            }
        };


        Image imagePiocheCarteWagon = new Image("images/wagons.png");
        piocheCarteWagon.setImage(imagePiocheCarteWagon);


        Image imagePiocheCarteDestination = new Image("images/destinations.png");
        piocheCarteDestination.setImage(imagePiocheCarteDestination);


        iJeu.cartesWagonVisiblesProperty().addListener(changeListener);


    }


    @FXML
    public void piocheCarte() {
        System.out.println("je pioche une carte wagon");
        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();

        iJeu.uneCarteWagonAEtePiochee();
    }

    @FXML
    public void piocheDestination() {
        System.out.println("je pioche une destination");
        IJeu iJeu = ((VueDuJeu) getScene().getRoot()).getJeu();
        iJeu.uneDestinationAEtePiochee();
    }


}

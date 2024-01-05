package fr.umontpellier.iut.vues;

import fr.umontpellier.iut.ICouleurWagon;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

/**
 * Cette classe représente la vue d'une carte Wagon.
 *
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueCarteWagon extends Pane {

    private ICouleurWagon couleurWagon;

    public VueCarteWagon(ICouleurWagon couleurWagon) {







        this.couleurWagon = couleurWagon;
        Image imageWagon = new Image("images/cartesWagons/carte-wagon-"+couleurWagon.toString().toUpperCase()+".png");
        ImageView imageView = new ImageView(imageWagon);
        getChildren().add(imageView);

    }

    public void creeBinding(){

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ((VueDuJeu) getScene().getRoot()).getJeu().uneCarteWagonAEteChoisie(couleurWagon);
            }
        });

    }


    public ICouleurWagon getCouleurWagon() {
        return couleurWagon;
    }

}

package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public ShipDaoImp ll;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        ObservableList<Ship> ships = ll.selectAll();
        //List<Ship> ships = pdi.selectByName("Lorcon");
        //List<Ship> ships = pdi.selectByDate(Timestamp.valueOf("2017-9-25 7:00:00"));
        System.out.println();
        for (Ship ship: ships) {
            System.out.println(ship.getId() + ". " + ship.getBerthNumber() + " " + ship.getBollardNumber() + " " + ship.getName() + " "
                    + ship.getETA() + " " + ship.getETD() + " " + ship.getLastPort() + " " + ship.getNextPort());
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}

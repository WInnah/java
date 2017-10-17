package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller{
    @FXML
    private TableView<Ship> tableShip;
    @FXML
    private TableColumn<Ship, Integer> ID;
    @FXML
    private TableColumn<Ship, String> Berth_No;
    @FXML
    private TableColumn<Ship, String> Bollard_No;
    @FXML
    private TableColumn<Ship, String> Name;
    @FXML
    private TableColumn<Ship, Timestamp> ETA;
    @FXML
    private TableColumn<Ship, Timestamp> ETD;
    @FXML
    private TableColumn<Ship, String> Last_Port;
    @FXML
    private TableColumn<Ship, String> Next_Port;
    @FXML
    private Button btnDisplay;


    private ObservableList<Ship> data = FXCollections.observableArrayList();
    private ConnectionConfiguration connect;

/*
    @FXML
    public void initialize() {
        ID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        Berth_No.setCellValueFactory(cellData -> cellData.getValue().berthNumberProperty());
        Bollard_No.setCellValueFactory(cellData -> cellData.getValue().bollardNumberProperty());
        Name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        ETA.setCellValueFactory(cellData -> cellData.getValue().ETAProperty());
        ETD.setCellValueFactory(cellData -> cellData.getValue().ETDProperty());
        Last_Port.setCellValueFactory(cellData -> cellData.getValue().lastPortProperty());
        Next_Port.setCellValueFactory(cellData -> cellData.getValue().nextPortProperty());
    }
*/

    @FXML
    private void loadDataFromDatabase(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            data = FXCollections.observableArrayList();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ship");

            while (resultSet.next()) {
                Ship ship = new Ship();
                ship.setId(resultSet.getInt("id"));
                ship.setBerthNumber(resultSet.getString("berth_number"));
                ship.setBollardNumber(resultSet.getString("bollard_number"));
                ship.setName(resultSet.getString("name"));
                ship.setETA(resultSet.getTimestamp("ETA"));
                ship.setETD(resultSet.getTimestamp("ETD"));
                ship.setLastPort(resultSet.getString("last_port"));
                ship.setNextPort(resultSet.getString("next_port"));
                data.add(ship);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

          tableShip.setItems(null);
          tableShip.setItems(data);

    }
}

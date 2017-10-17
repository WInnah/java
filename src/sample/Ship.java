package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

import java.sql.Timestamp;

public class Ship {
    private IntegerProperty id;
    private StringProperty berthNumber;
    private StringProperty bollardNumber;
    private StringProperty name;
    private SimpleObjectProperty<Timestamp> ETA;
    private SimpleObjectProperty<Timestamp> ETD;
    private StringProperty lastPort;
    private StringProperty nextPort;


    public Ship() {
    }

    public Ship(StringProperty berthNumber, StringProperty bollardNumber, StringProperty name, SimpleObjectProperty<Timestamp> ETA, SimpleObjectProperty<Timestamp> ETD, StringProperty lastPort, StringProperty nextPort) {
        //this.id = id;
        this.berthNumber = berthNumber;
        this.bollardNumber = bollardNumber;
        this.name = name;
        this.ETA = ETA;
        this.ETD = ETD;
        this.lastPort = lastPort;
        this.nextPort = nextPort;
    }


    public int getId() {
        return id.get();
    }


    public IntegerProperty idProperty() {
        return id;
    }


    public void setId(int id) {
        this.id.set(id);
    }


    public String getBerthNumber() {
        return berthNumber.get();
    }

    public StringProperty berthNumberProperty() {
        return berthNumber;
    }

    public void setBerthNumber(String berthNumber) {
        this.berthNumber.set(berthNumber);
    }

    public String getBollardNumber() {
        return bollardNumber.get();
    }

    public StringProperty bollardNumberProperty() {
        return bollardNumber;
    }

    public void setBollardNumber(String bollardNumber) {
        this.bollardNumber.set(bollardNumber);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Timestamp getETA() {
        return ETA.get();
    }

    public SimpleObjectProperty<Timestamp> ETAProperty() {
        return ETA;
    }

    public void setETA(Timestamp ETA) {
        this.ETA.set(ETA);
    }

    public Timestamp getETD() {
        return ETD.get();
    }

    public SimpleObjectProperty<Timestamp> ETDProperty() {
        return ETD;
    }

    public void setETD(Timestamp ETD) {
        this.ETD.set(ETD);
    }

    public String getLastPort() {
        return lastPort.get();
    }

    public StringProperty lastPortProperty() {
        return lastPort;
    }

    public void setLastPort(String lastPort) {
        this.lastPort.set(lastPort);
    }

    public String getNextPort() {
        return nextPort.get();
    }

    public StringProperty nextPortProperty() {
        return nextPort;
    }

    public void setNextPort(String nextPort) {
        this.nextPort.set(nextPort);
    }
}

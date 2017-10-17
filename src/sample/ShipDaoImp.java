package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.*;

public class ShipDaoImp {
    public void createShipTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ship(id int primary key unique auto_increment," +
                    "berth_number varchar(60), bollard_number varchar(60), name varchar(60), ETA timestamp, ETD timestamp, " +
                    "last_port varchar(60), next_port varchar(60))");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insert(Ship ship) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO ship (berth_number, bollard_number, " +
                    "name, ETA, ETD, last_port, next_port)" + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, ship.getBerthNumber());
            preparedStatement.setString(2, ship.getBollardNumber());
            preparedStatement.setString(3, ship.getName());
            preparedStatement.setTimestamp(4, ship.getETA());
            preparedStatement.setTimestamp(5, ship.getETD());
            preparedStatement.setString(6, ship.getLastPort());
            preparedStatement.setString(7, ship.getNextPort());
            preparedStatement.execute();
            System.out.println("INSERT INTO ship (berth_number, bollard_number, " +
                    "name, ETA, ETD, last_port, next_port)" + "VALUES (?, ?, ?, ?, ?, ?, ?)");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Ship selectById(int id) {
        Ship ship = new Ship();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ship WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ship.setId(resultSet.getInt("id"));
                ship.setBerthNumber(resultSet.getString("berth_number"));
                ship.setBollardNumber(resultSet.getString("bollard_number"));
                ship.setName(resultSet.getString("name"));
                ship.setETA(resultSet.getTimestamp("ETA"));
                ship.setETD(resultSet.getTimestamp("ETD"));
                ship.setLastPort(resultSet.getString("last_port"));
                ship.setNextPort(resultSet.getString("next_port"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return ship;
    }

    public static ObservableList<Ship> selectAll() {
        ObservableList <Ship> ships = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
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

                ships.add(ship);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ships;
    }




    public List<Ship> selectByName(String name) {
        List <Ship> ships = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ship WHERE name = ?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

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

                ships.add(ship);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return ships;
    }

    public List<Ship> selectByDate(Timestamp timestamp) {
        List <Ship> ships = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ship WHERE ETA <= ? and ETD >= ?");
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setTimestamp(2, timestamp);
            resultSet = preparedStatement.executeQuery();

            System.out.println("SELECT * FROM ship WHERE timestamp >= ETA and timestamp <= ETD");
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

                ships.add(ship);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return ships;
    }

    /*
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM ship WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM ship WHERE id = ?");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
*/
    public void update(Ship ship, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE ship SET " +
                    "berth_number = ?, bollard_number = ?, name = ?, ETA = ?, ETD = ?, last_port = ?, next_port = ? WHERE id = ?");
            preparedStatement.setInt(8, id);
            preparedStatement.setString(1, ship.getBerthNumber());
            preparedStatement.setString(2, ship.getBollardNumber());
            preparedStatement.setString(3, ship.getName());
            preparedStatement.setTimestamp(4, ship.getETA());
            preparedStatement.setTimestamp(5, ship.getETD());
            preparedStatement.setString(6, ship.getLastPort());
            preparedStatement.setString(7, ship.getNextPort());
            preparedStatement.executeUpdate();

            System.out.println("UPDATE ship SET " +
                    "berth_number = ?, bollard_number = ?, name = ?, ETA = ?, ETD = ?, last_port = ?, next_port = ? WHERE id = ?");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManeger;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Manufacturer;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

import java.sql.*;

public class MobileDaoJdbcImpl implements MobileDao {
    private static ConnectionManeger connectionManeger = ConnectionManagerJdbcImpl.getInstance();
    @Override
    public boolean add(Mobile mobile) {
        try(Connection connection = connectionManeger.getConnection()) {
//            String generatedKeys[]= {"id"};
            Manufacturer manufacturer = new Manufacturer(0,"4444", "44444");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturer VALUES (DEFAULT, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
//            preparedStatement.setInt(3, mobile.getManufacturer());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                int i = (int) resultSet.getInt("id");
                System.out.println(i);}

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Mobile get(Integer id) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mobile WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Mobile mobile = new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getInt(4)
                );
                return mobile;
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateById(Mobile mobile) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mobile SET model = ?, price = ?, monufacturer_id = ? WHERE id = ?");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer());
            preparedStatement.setInt(4, mobile.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                        mobile.setId(resultSet.getInt(1));
                        mobile.setModel(resultSet.getString(2));
                        mobile.setPrice(resultSet.getFloat(3));
                        mobile.setManufacturer(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mobile WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

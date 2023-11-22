package com.formation.jdbc;

import com.formation.ConnectionManager;
import com.formation.model.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitDao implements GenericCrud<Fruit, Long> {

    @Override
    public List<Fruit> fetchAll() {
        String query = "SELECT id, name, expirationDate FROM fruits_boris";
        List<Fruit> fruitList = new ArrayList<>();
        try (Statement st = ConnectionManager.getInstance().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                Date expirationDate = rs.getDate("expirationDate");
                Fruit fruit = new Fruit(id, name, expirationDate);
                fruitList.add(fruit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fruitList;
    }

    @Override
    public Fruit fetchById(Long aLong) {
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public Fruit create(Fruit fruit) {
        //
        return null;
    }

    @Override
    public Fruit update(Long aLong, Fruit fruit) {
        return null;
    }


}

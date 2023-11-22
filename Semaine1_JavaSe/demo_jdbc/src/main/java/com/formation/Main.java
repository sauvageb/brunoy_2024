package com.formation;

import com.formation.jdbc.FruitDao;
import com.formation.model.Fruit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDao();
        List<Fruit> fruitList = fruitDao.fetchAll();

        for (Fruit fruit: fruitList){
            System.out.println(fruit);
        }

        ConnectionManager.close();
    }

}

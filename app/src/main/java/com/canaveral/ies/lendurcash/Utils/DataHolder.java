package com.canaveral.ies.lendurcash.Utils;

import com.canaveral.ies.lendurcash.Entities.Deuda;
import com.canaveral.ies.lendurcash.Entities.Deuditas;
import com.canaveral.ies.lendurcash.Entities.User;
import com.canaveral.ies.lendurcash.utils.FirebaseManager;

import java.util.ArrayList;

public class DataHolder {
    public static DataHolder instance = new DataHolder();

    public FirebaseManager firebaseManager;
    public User user;

    public DataHolder () {
        firebaseManager = new FirebaseManager();
        ArrayList<User> friends = new ArrayList<User>();
        friends.add(new User ( "rafa", "rafa@rafa.com", "123456", null, null));
        friends.add(new User ( "vic", "vic@vic.com", "123456", null, null));

        ArrayList<Deuda> deudas = new ArrayList<>();
        ArrayList<Deuditas> deuditas = new ArrayList<>();
        deuditas.add(new Deuditas("por putas",56.4,true));
        deudas.add(new Deuda("rafa",24.3, deuditas));

        deuditas = new ArrayList<>();
       // deuditas.add(new Deuditas("por droga",5.4,false));
        deudas.add(new Deuda("vic", 5.5,deuditas));

        user = new User("admin", "admin@admin.com", "123456", friends, deudas);

    }
}
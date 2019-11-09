package com.arevalo.notesapplication.repositories;

import com.arevalo.notesapplication.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static void create(String name,String fullname, String email, String password){
        User user = new User(name, fullname, email, password);
        SugarRecord.save(user);
    }

    public static User Login(String username, String password){
        List<User> users = SugarRecord.listAll(User.class);
        for (User u: users){
            if(u.getName().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public static  User findByUsername(String username){
        List<User> users = SugarRecord.listAll(User.class);
        for (User u: users){
            if(u.getName().equals(username)){
                return u;
            }
        }
        return null;
    }

}

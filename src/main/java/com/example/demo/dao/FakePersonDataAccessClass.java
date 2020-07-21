/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aswin
 */
@Repository("fakeDao")
public class FakePersonDataAccessClass implements PersonDao {
private static ArrayList<Person>  DB = new ArrayList<Person>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
       return DB;
    }

    @Override
    public int insertPerson(Person person) {
        return PersonDao.super.insertPerson(person); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
    return DB.stream().
            filter(person -> person.getId().equals(id))
            .findFirst();    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        else{
            DB.remove(personMaybe.get());
        return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int i = DB.indexOf(p);
                    if(i>=0){
                        DB.set(i,new Person(id,person.getName()));
                        return 1;
                    }
                       return 0;   
                }
        ).orElse(0);
    }
    
}

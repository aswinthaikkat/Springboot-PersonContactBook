/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author aswin
 */
@Service
public class PersonService {
    private final PersonDao personDao;
    
    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao) {
        this.personDao = personDao;
    }
   
    public int addPerson(@RequestBody Person person){
       return personDao.insertPerson(person);
    }
    
    public List<Person> getAllPeople(){
        return personDao.selectAllPerson();
    }
    
    public Optional<Person> getPersonById(UUID id){
    return personDao.selectPersonById(id);}
    
    public List<Person> deletePersonById(UUID id){
    personDao.deletePersonById(id);
    return getAllPeople();}
    
    public Optional<Person> updatePersonById(UUID id,Person person){
    personDao.updatePersonById(id,person);
    return getPersonById(id);}
    
}

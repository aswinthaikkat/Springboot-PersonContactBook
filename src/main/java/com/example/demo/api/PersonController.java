/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aswin
 */
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personservice;
    @Autowired
    public PersonController(PersonService personservice) {
        this.personservice = personservice;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personservice.addPerson(person);
        
    }
    
    @GetMapping
    public List<Person> getAllPeople(){
        return personservice.getAllPeople();
    }
    
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
    return personservice.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public List<Person> deletePersonById(@PathVariable("id") UUID id){
    return personservice.deletePersonById(id);}
    
    @PutMapping(path = "{id}")
    public Person updatePersonById(@PathVariable("id") UUID id, @RequestBody Person person){
    return personservice.updatePersonById(id,person).orElse(null);}
    
}

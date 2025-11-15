package com.example.Backend_2.Service;

import com.example.Backend_2.Excepion.ResourceNotFoundException;
import com.example.Backend_2.Model.Contact;
import com.example.Backend_2.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;



    public Iterable<Contact> ListContact(){
        return repository.findAll();
    }

    public Contact GetContact( int id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException());
    }

    public Contact PostContact(Contact newCOntact){
        newCOntact.setCreated_at(LocalDateTime.now());
        return  repository.save(newCOntact);
    }

    public Contact PutContact( Integer id ,  Contact newCOntact){
        Contact oldCOntact= repository.findById(id).orElseThrow(()->new ResourceNotFoundException());

        oldCOntact.setName(newCOntact.getName());
        oldCOntact.setEmail(newCOntact.getEmail());
        //oldCOntact.setCreatedAt(newCOntact.getCreatedAt());

        return repository.save(oldCOntact);
    }

    public void DeleteContact( Integer id){
        Contact oldCOntact= repository.findById(id).orElseThrow(()->new ResourceNotFoundException());

        repository.delete(oldCOntact);
    }


}

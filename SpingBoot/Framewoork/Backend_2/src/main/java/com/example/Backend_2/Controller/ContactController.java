package com.example.Backend_2.Controller;

import com.example.Backend_2.Model.Contact;
import com.example.Backend_2.Repository.ContactRepository;
import com.example.Backend_2.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    public Iterable<Contact> ListContact(){
        return service.ListContact();
    }

    @GetMapping("/{id}")
    public Contact GetContact(@PathVariable int id){
        return service.GetContact(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact PostContact(@RequestBody Contact newCOntact){
        return service.PostContact(newCOntact);
    }

    @PutMapping("/{id}")
    public Contact PutContact(@PathVariable Integer id , @RequestBody Contact newCOntact){
        return service.PutContact(id,newCOntact);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void DeleteContact(@PathVariable Integer id){
       service.DeleteContact(id);
    }




}

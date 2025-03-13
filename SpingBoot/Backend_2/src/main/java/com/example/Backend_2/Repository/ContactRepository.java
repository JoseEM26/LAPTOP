package com.example.Backend_2.Repository;

import com.example.Backend_2.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}

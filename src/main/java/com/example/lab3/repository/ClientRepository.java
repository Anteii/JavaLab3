package com.example.lab3.repository;

import com.example.lab3.model.Book;
import com.example.lab3.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}

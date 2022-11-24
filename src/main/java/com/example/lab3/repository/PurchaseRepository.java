package com.example.lab3.repository;

import com.example.lab3.model.Book;
import com.example.lab3.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}

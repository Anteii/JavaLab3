package com.example.lab3.controller.api;

import com.example.lab3.dto.PurchaseDto;
import com.example.lab3.model.Purchase;
import com.example.lab3.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/purchases", produces = {"application/json", "application/xml"})
public class PurchaseController {
    final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/{id}")
    public Purchase findById(@PathVariable Integer id){
        return purchaseRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Purchase purchase){
        purchaseRepository.saveAndFlush(purchase);
    }

    @PostMapping("/create")
    public Purchase create(@RequestBody PurchaseDto purchaseDto){
        Purchase purchase = new Purchase(purchaseDto.getBookId(), purchaseDto.getClientId(), purchaseDto.getAmount());
        purchaseRepository.saveAndFlush(purchase);
        return purchase;
    }

    @DeleteMapping("/delete/{id}")
    public Purchase delete(@PathVariable Integer id){
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchaseRepository.delete(purchase);
        return purchase;
    }
}

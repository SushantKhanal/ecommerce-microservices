package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryServiceImpl;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) throws InterruptedException {
        return inventoryServiceImpl.isInStock(skuCode);
    }
}

//PathVariable: http://localhost:8082/api/inventory/iphone13,iphone14,iphone15
//RequestParam: http://localhost:8082/api/inventory?sku-code=iphone13&sku-code=iphone-14&sku-code=iphone15
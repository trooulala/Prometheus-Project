package com.learning.prometheus.entity;

import com.learning.prometheus.enums.InventoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Inventories")
public class Inventory {
    @Id
    private Integer id;

    private String brand;

    @Enumerated(EnumType.STRING)
    private InventoryType inventoryType;

    private String processor;

    private Integer ram;

    private Integer storage;

    @OneToMany(mappedBy = "inventory")
    private List<Transaction> transactions;
}

package com.taslim.inventoryservice;

import com.taslim.inventoryservice.model.Inventory;
import com.taslim.inventoryservice.repository.InventoryRepository;
import com.taslim.inventoryservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository )
	{
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("DSA12");
			inventory.setQuantity(23);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("DSA2");
			inventory1.setQuantity(20);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}

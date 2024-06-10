package com.pj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ExampleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleServiceApplication.class, args);
	}

}

@RestController
@RequestMapping("/apiProducto")
class ProductController {

	@GetMapping("/find/3")
    public Product getProducto() {
		return new Product(1, "Ejemplo de Producto(primero)", 19.99);
    }
	
	@GetMapping("/find/2")
    public String getProducto1() {
        return "Producto encontrado(segundo)";
    }
	
    @GetMapping("/find/1")
    public Product getProduct() {
        return new Product(1, "Ejemplo de Producto(tercero)", 19.99);
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
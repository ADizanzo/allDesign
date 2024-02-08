package com.example.alldesign;

public class Product {
    private final long id;
    private final String name;
    private final String price;

    public Product(long id, String name, String price) {
        // Puedes agregar validaciones aquí según tus necesidades
        if (name == null || price == null) {
            throw new IllegalArgumentException("El nombre y el precio no pueden ser nulos");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPrice() {
        return price;
    }
}



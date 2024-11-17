package com.example.Nat_kt.entity;

public class Book {
private Long id;
private String name;
private String kind;
private Integer price;
private Integer quantity;

    public Book() {
    }

    public Book(Long id, String name, String kind, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

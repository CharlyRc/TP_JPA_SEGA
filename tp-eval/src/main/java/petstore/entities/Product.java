package petstore.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="code")
    private String code;
    @Column(name="label")
    private String label;
    @Column(name="price")
    private Double price;
    @ManyToMany
    @JoinTable(name="petstore_product",
            joinColumns = @JoinColumn(name="id_pro", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="id_petStore",referencedColumnName = "id")
    )
    private Set<PetStore> petStores;
    @Enumerated(EnumType.STRING)
    private ProdType prodType;

    public Product() {
    }

    public Product(String code, String label, Double price, Set<PetStore> petStores, ProdType prodType) {
        this.code = code;
        this.label = label;
        this.price = price;
        this.petStores = petStores;
        this.prodType = prodType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public ProdType getProdType() {
        return prodType;
    }

    public void setProdType(ProdType prodType) {
        this.prodType = prodType;
    }
}

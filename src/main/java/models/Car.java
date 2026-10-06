package models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="coche")
public class Car {
    private Integer id;
    private String brand;
    private String model;
    private Double engine;

    public Car() {
    }

    //Esta etiqueta asocia el atributo con un atributo del RootElement
    @XmlAttribute (name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //Esta etiqueta asocia el atributo con un elemento hijo del RootElement
    @XmlElement (name="marca")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement(name="modelo")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement(name="cilindrada")
    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }
}

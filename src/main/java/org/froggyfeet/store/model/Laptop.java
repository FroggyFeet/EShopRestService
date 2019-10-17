package org.froggyfeet.store.model;

import org.froggyfeet.store.model.interfaces.Good;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "laptops")
public class Laptop extends AbstractPersistable<Integer> implements Good {
    @Basic
    @Column(name = "vendor")
    private String vendor;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "operating_system")
    private String operatingSystem;
    @Basic
    @Column(name = "processor")
    private String processor;

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return vendor.equals(laptop.vendor) &&
                model.equals(laptop.model) &&
                operatingSystem.equals(laptop.operatingSystem) &&
                processor.equals(laptop.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vendor, model, operatingSystem, processor);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }
}

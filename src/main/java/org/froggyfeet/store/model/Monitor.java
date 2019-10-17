package org.froggyfeet.store.model;

import org.froggyfeet.store.model.interfaces.Good;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "monitors")
public class Monitor extends AbstractPersistable<Integer> implements Good {
    @Basic
    @Column(name = "vendor")
    private String vendor;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "diagonal")
    private double diagonal;
    @Basic
    @Column(name = "buttons_type")
    private String buttonsType;

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

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public String getButtonsType() {
        return buttonsType;
    }

    public void setButtonsType(String buttonsType) {
        this.buttonsType = buttonsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return Double.compare(monitor.diagonal, diagonal) == 0 &&
                vendor.equals(monitor.vendor) &&
                model.equals(monitor.model) &&
                buttonsType.equals(monitor.buttonsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vendor, model, diagonal, buttonsType);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", buttonsType='" + buttonsType + '\'' +
                '}';
    }
}

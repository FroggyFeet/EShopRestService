package org.froggyfeet.store.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order extends AbstractPersistable<Integer> {
    @Basic
    @Column(name = "date")
    private LocalDateTime localDateTime;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "shipping_type")
    private String shippingType;

    @Basic
    @Column(name = "sent")
    private boolean sent;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_cellphones",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cellphone_id"))
    private List<Cellphone> cellphones;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_laptops",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "laptop_id"))
    private List<Laptop> laptops;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_monitors",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "monitor_id"))
    private List<Monitor> monitors;


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public List<Cellphone> getCellphones() {
        return cellphones;
    }

    public void setCellphones(List<Cellphone> cellphones) {
        this.cellphones = cellphones;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return localDateTime.equals(order.localDateTime) &&
                address.equals(order.address) &&
                shippingType.equals(order.shippingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), localDateTime, address, shippingType);
    }

    @Override
    public String toString() {
        return "Order{" +
                "localDateTime=" + localDateTime +
                ", address='" + address + '\'' +
                ", shippingType='" + shippingType + '\'' +
                '}';
    }
}

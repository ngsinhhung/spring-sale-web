package org.pojo;

import javax.persistence.*;

@Entity
@Table(name = "order_detail", schema = "saledb", catalog = "")
public class OrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "order_id", nullable = false, insertable = false, updatable = false)
    private int orderId;
    @Basic
    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private int productId;
    @Basic
    @Column(name = "unit_price", nullable = true, precision = 0)
    private Integer unitPrice;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private SaleOrder saleOrderByOrderId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product productByProductId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SaleOrder getSaleOrderByOrderId() {
        return saleOrderByOrderId;
    }

    public void setSaleOrderByOrderId(SaleOrder saleOrderByOrderId) {
        this.saleOrderByOrderId = saleOrderByOrderId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}

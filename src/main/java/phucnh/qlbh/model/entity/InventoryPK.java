package phucnh.qlbh.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class InventoryPK implements Serializable {
    
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "warehouse_id")
    private Long warehouseId;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryPK that = (InventoryPK) o;
        return Objects.equals(productId, that.productId) && Objects.equals(warehouseId, that.warehouseId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(productId, warehouseId);
    }
}
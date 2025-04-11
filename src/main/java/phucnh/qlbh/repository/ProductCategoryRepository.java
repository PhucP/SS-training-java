package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "productCategory")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}

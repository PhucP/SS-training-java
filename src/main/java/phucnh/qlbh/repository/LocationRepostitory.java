package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.Location;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepostitory extends JpaRepository<Location, Long> {

}

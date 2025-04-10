package phucnh.qlbh.service.Impls;

import org.springframework.stereotype.Service;

import phucnh.qlbh.model.entity.Region;
import phucnh.qlbh.repository.RegionRepository;
import phucnh.qlbh.service.RegionService;

@Service
public class RegionServiceImpl extends BaseServiceImpl<Region, Long> implements RegionService{

    public RegionServiceImpl(RegionRepository repository) {
        super(repository, new Region());
    }

}

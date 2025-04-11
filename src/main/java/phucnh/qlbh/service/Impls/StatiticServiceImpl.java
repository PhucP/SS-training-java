package phucnh.qlbh.service.Impls;

import java.util.List;

import org.springframework.stereotype.Service;

import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;
import phucnh.qlbh.model.response.RevenueProduct;
import phucnh.qlbh.model.response.TopCustomer;
import phucnh.qlbh.repository.statitic.StatiticRepository;
import phucnh.qlbh.service.StatiticService;

@Service
public class StatiticServiceImpl implements StatiticService {
    private final StatiticRepository statiticRepository;

    public StatiticServiceImpl(StatiticRepository statiticRepository) {
        this.statiticRepository = statiticRepository;
    }
    @Override
    public List<RevenueByEmployeePerMonth> getRevenueByEmployeePerMonths(Long year) {
        return statiticRepository.getRevenueByEmployeePerMonth(year);
    }
    @Override
    public List<TopCustomer> getTopCustomer(Long year) {
        return statiticRepository.getTopCustomer(year);
    }
    @Override
    public List<RevenueProduct> getRevenueProduct() {
        return statiticRepository.getRevenueProduct();
    }
    
}

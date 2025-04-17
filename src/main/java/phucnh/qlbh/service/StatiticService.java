package phucnh.qlbh.service;

import java.util.List;

import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;
import phucnh.qlbh.model.response.RevenueProduct;
import phucnh.qlbh.model.response.TopCustomer;
import phucnh.qlbh.model.response.PagedResponse;

public interface StatiticService {
    List<RevenueByEmployeePerMonth> getRevenueByEmployeePerMonths(Long year);
    List<TopCustomer> getTopCustomer(Long year);
    List<RevenueProduct> getRevenueProduct();
    PagedResponse<RevenueProduct> getRevenueProductPaginated(int page, int size);
}   

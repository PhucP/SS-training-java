package phucnh.qlbh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;
import phucnh.qlbh.model.response.RevenueProduct;
import phucnh.qlbh.model.response.TopCustomer;
import phucnh.qlbh.service.StatiticService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/statitic")
public class StatiticController {
    private StatiticService statiticService;

    public StatiticController(StatiticService statiticService) {
        this.statiticService = statiticService;
    }

    @PostMapping("/revenue-by-employee-per-month")
    public ResponseEntity<List<RevenueByEmployeePerMonth>> getRevenueByEmployeePerMonth(@PathParam("year") Long year) {
        return ResponseEntity.ok(statiticService.getRevenueByEmployeePerMonths(year));
    }
    
    @PostMapping("/get-top-customer")
    public ResponseEntity<List<TopCustomer>> getTopCustomer(@PathParam("year") Long year) {
        return ResponseEntity.ok(statiticService.getTopCustomer(year));
    }

    @GetMapping("/get-product-revenue")
    public ResponseEntity<List<RevenueProduct>> getProductRevenue() {
        return ResponseEntity.ok(statiticService.getRevenueProduct());
    }
    
    
}

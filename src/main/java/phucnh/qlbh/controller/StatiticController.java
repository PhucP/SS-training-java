package phucnh.qlbh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;
import phucnh.qlbh.model.response.PagedResponse;
import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;
import phucnh.qlbh.model.response.RevenueProduct;
import phucnh.qlbh.model.response.TopCustomer;
import phucnh.qlbh.service.StatiticService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/statitic")
public class StatiticController {
    private StatiticService statiticService;

    public StatiticController(StatiticService statiticService) {
        this.statiticService = statiticService;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    

    @ResponseBody()
    @PostMapping("/revenue-by-employee-per-month")
    public ResponseEntity<List<RevenueByEmployeePerMonth>> getRevenueByEmployeePerMonth(@PathParam("year") Long year) {
        return ResponseEntity.ok(statiticService.getRevenueByEmployeePerMonths(year));
    }
    
    @ResponseBody()
    @PostMapping("/get-top-customer")
    public ResponseEntity<List<TopCustomer>> getTopCustomer(@PathParam("year") Long year) {
        return ResponseEntity.ok(statiticService.getTopCustomer(year));
    }

    @ResponseBody()
    @GetMapping("/get-product-revenue")
    public ResponseEntity<List<RevenueProduct>> getProductRevenue() {
        return ResponseEntity.ok(statiticService.getRevenueProduct());
    }
    
    @ResponseBody()
    @GetMapping("/get-product-revenue/paginated")
    public ResponseEntity<PagedResponse<RevenueProduct>> getProductRevenuePaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(statiticService.getRevenueProductPaginated(page, size));
    }
}

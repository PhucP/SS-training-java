package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phucnh.qlbh.model.entity.Employee;

// import java.util.List;
// import java.util.ArrayList;

// import org.springframework.stereotype.Repository;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.Query;
// import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;

// @Repository
// public class EmployeeRepository {
    
//     @PersistenceContext 
//     private EntityManager entityManager;

//     @SuppressWarnings("unchecked")
//     public List<RevenueByEmployeePerMonth> getRevenueByEmployeePerMonth() {
//         Query query = entityManager.createNativeQuery(
//                 """
//                 SELECT
//                     EMPLOYEES.EMPLOYEE_ID as employee_id, 
//                     CONCAT(CONCAT(EMPLOYEES.FIRST_NAME, ' '), EMPLOYEES.LAST_NAME) AS full_name,
//                     SUM(ORDER_ITEMS.QUANTITY * PRODUCTS.LIST_PRICE) as total_revenue,
//                     TO_CHAR(ORDERS.ORDER_DATE, 'YYYY-MM') as month
//                 FROM
//                     EMPLOYEES, ORDERS, ORDER_ITEMS, PRODUCTS
//                 WHERE
//                     EXTRACT(YEAR FROM ORDERS.ORDER_DATE) = 2017
//                     AND UPPER(ORDERS.STATUS) = 'SHIPPED'
//                     AND EMPLOYEES.EMPLOYEE_ID = ORDERS.SALESMAN_ID
//                     AND ORDER_ITEMS.ORDER_ID = ORDERS.ORDER_ID
//                     AND PRODUCTS.PRODUCT_ID = ORDER_ITEMS.PRODUCT_ID
//                 GROUP BY
//                     TO_CHAR(ORDERS.ORDER_DATE, 'YYYY-MM'),
//                     EMPLOYEES.EMPLOYEE_ID, CONCAT(CONCAT(EMPLOYEES.FIRST_NAME, ' '), EMPLOYEES.LAST_NAME)
//                 ORDER BY
//                     month,
//                     total_revenue DESC
//                 """);
        
//         List<Object[]> results = query.getResultList();
//         List<RevenueByEmployeePerMonth> revenueList = new ArrayList<>();
        
//         for (Object[] record : results) {
//             RevenueByEmployeePerMonth revenue = new RevenueByEmployeePerMonth();
//             revenue.setEmployeeId(Long.valueOf(record[0].toString()));
//             revenue.setFullName(record[1].toString());
//             revenue.setTotalRevenue(Double.valueOf(record[2].toString()));
//             revenue.setMonth(record[3].toString());
//             revenueList.add(revenue);
//         }
            
//         return revenueList;
//     }
// }

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

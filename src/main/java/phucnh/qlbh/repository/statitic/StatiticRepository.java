package phucnh.qlbh.repository.statitic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import phucnh.qlbh.model.response.RevenueByEmployeePerMonth;
import phucnh.qlbh.model.response.RevenueProduct;
import phucnh.qlbh.model.response.TopCustomer;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class StatiticRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<RevenueByEmployeePerMonth> getRevenueByEmployeePerMonth(Long year) {
        String sql = """
            SELECT 
                EMPLOYEES.EMPLOYEE_ID, CONCAT(CONCAT(EMPLOYEES.FIRST_NAME, ' '), EMPLOYEES.LAST_NAME) AS FULL_NAME,
                SUM(ORDER_ITEMS.QUANTITY * PRODUCTS.LIST_PRICE) TOTAL_REVENUE, 
                TO_CHAR(ORDERS.ORDER_DATE, 'YYYY-MM') MONTH 
            FROM 
                EMPLOYEES, ORDERS, ORDER_ITEMS, PRODUCTS
            WHERE 
                EXTRACT(YEAR FROM ORDERS.ORDER_DATE) = :year 
                AND UPPER(ORDERS.STATUS) = 'SHIPPED' 
                AND EMPLOYEES.EMPLOYEE_ID = ORDERS.SALESMAN_ID 
                AND ORDER_ITEMS.ORDER_ID = ORDERS.ORDER_ID 
                AND PRODUCTS.PRODUCT_ID = ORDER_ITEMS.PRODUCT_ID 
            GROUP BY TO_CHAR(ORDERS.ORDER_DATE, 'YYYY-MM'), EMPLOYEES.EMPLOYEE_ID, 
                CONCAT(CONCAT(EMPLOYEES.FIRST_NAME, ' '), EMPLOYEES.LAST_NAME) 
            ORDER BY 
                MONTH, TOTAL_REVENUE DESC
            FETCH NEXT 10 ROWS WITH TIES
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("year", year);
        List<Object[]> results = query.getResultList();
        
        return results.stream().map(result -> new RevenueByEmployeePerMonth(
            ((Number) result[0]).longValue(), 
            (String) result[1],               
            ((BigDecimal) result[2]).doubleValue(), 
            (String) result[3]                 
        )).toList();
    }

    public List<TopCustomer> getTopCustomer(Long year) {
        String sql = """
            SELECT
                CUSTOMERS.CUSTOMER_ID, CUSTOMERS.NAME, CUSTOMERS.ADDRESS, CUSTOMERS.CREDIT_LIMIT,
                SUM(ORDER_ITEMS.QUANTITY * PRODUCTS.LIST_PRICE) TOTAL_REVENUE
            FROM
                CUSTOMERS, ORDERS, ORDER_ITEMS, PRODUCTS
            WHERE
                CUSTOMERS.CUSTOMER_ID = ORDERS.CUSTOMER_ID
                AND ORDERS.ORDER_ID = ORDER_ITEMS.ORDER_ID
                AND ORDER_ITEMS.PRODUCT_ID = PRODUCTS.PRODUCT_ID
                AND EXTRACT(YEAR FROM ORDERS.ORDER_DATE) = :year
                AND UPPER(ORDERS.STATUS) = 'SHIPPED'
            GROUP BY
                CUSTOMERS.CUSTOMER_ID, 
                CUSTOMERS.NAME, 
                CUSTOMERS.ADDRESS, 
                CUSTOMERS.CREDIT_LIMIT
            ORDER BY
                TOTAL_REVENUE DESC
                FETCH NEXT 10 ROWS WITH TIES
                """;
        
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("year", year);
        List<Object[]> results = query.getResultList();

        return results.stream().map(result -> TopCustomer.builder()
                .customerId(((Number)result[0]).longValue())
                .name((String)result[1])
                .address((String)result[2])
                .creditLimit(((Number)result[3]).longValue())
                .totalRevenue(((Number)result[4]).doubleValue())
                .build()
        ).toList();
    }

    public List<RevenueProduct> getRevenueProduct() {
        String sql = """
                WITH SHORT_INVENTORY AS (
                    SELECT PRODUCT_ID, SUM(QUANTITY) AS IN_STOCK
                    FROM INVENTORIES
                    GROUP BY PRODUCT_ID
                ),
                PRODUCT_ITEM AS (
                    SELECT PRODUCT_ID, SUM(QUANTITY) TOTAL_QUANTITY
                    FROM ORDER_ITEMS
                    GROUP BY PRODUCT_ID
                )
                SELECT
                    PRODUCTS.PRODUCT_ID,
                    PRODUCTS.PRODUCT_NAME,
                    NVL(PRODUCT_ITEM.TOTAL_QUANTITY * PRODUCTS.LIST_PRICE, 0) TOTAL_REVENUE,
                    NVL(SHORT_INVENTORY.IN_STOCK, 0) IN_STOCK
                FROM
                    SHORT_INVENTORY, PRODUCT_ITEM, PRODUCTS
                WHERE
                    PRODUCT_ITEM.PRODUCT_ID(+) = PRODUCTS.PRODUCT_ID
                    AND PRODUCTS.PRODUCT_ID = SHORT_INVENTORY.PRODUCT_ID(+)
                ORDER BY
                    TOTAL_REVENUE DESC,
                    SHORT_INVENTORY.IN_STOCK
                """;

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        return results.stream().map(result -> RevenueProduct.builder()
                .productId(((Number)result[0]).longValue())
                .productName((String)result[1])
                .totalRevenue(((Number)result[2]).doubleValue())
                .instock(((Number)result[3]).longValue())
                .build()
        ).toList();
    }
}

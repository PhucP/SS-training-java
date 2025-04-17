WITH RECURSIVE months AS (
  SELECT TO_DATE('2024-02-01', 'YYYY-MM-DD') as month_date
  FROM dual
  UNION ALL
  SELECT ADD_MONTHS(month_date, 1)
  FROM months
  WHERE month_date < TO_DATE('2024-06-01', 'YYYY-MM-DD')
),
monthly_dependents AS (
  SELECT 
    e.employee_id,
    e.employee_name,
    m.month_date,
    COUNT(d.dependent_id) as dependent_count
  FROM employees e
  CROSS JOIN months m
  LEFT JOIN dependencies d ON e.employee_id = d.employee_id
    AND m.month_date >= TRUNC(d.effective_date, 'MM')
    AND m.month_date <= TRUNC(d.end_date, 'MM')
  GROUP BY e.employee_id, e.employee_name, m.month_date
)
SELECT 
  employee_id,
  employee_name,
  SUM(dependent_count) as total_dependents
FROM monthly_dependents
GROUP BY employee_id, employee_name
ORDER BY employee_id; 
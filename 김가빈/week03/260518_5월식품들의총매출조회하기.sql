SELECT p.product_id, p.product_name, SUM(p.price * o.amount) AS total_sales
FROM food_product p
         JOIN food_order o ON p.product_id = o.product_id
WHERE DATE_FORMAT(o.produce_date, '%Y-%m') = '2022-05'
GROUP BY p.product_id,  p.product_name
ORDER BY total_sales DESC, p.product_id
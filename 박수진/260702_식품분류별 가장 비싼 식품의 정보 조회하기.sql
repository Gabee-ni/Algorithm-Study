SELECT category, price, product_name
FROM food_product f
WHERE category IN ('과자', '국', '김치', '식용유')
    AND price = (
        SELECT max(price)
        FROM food_product
        WHERE category = f.category
    )
GROUP BY category
ORDER BY price DESC;
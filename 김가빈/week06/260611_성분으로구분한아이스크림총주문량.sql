-- 코드를 입력하세요
SELECT i.ingredient_type, SUM(total_order) AS total_order
FROM first_half h
         JOIN icecream_info i ON h.flavor = i.flavor
GROUP BY i.ingredient_type
ORDER BY total_order
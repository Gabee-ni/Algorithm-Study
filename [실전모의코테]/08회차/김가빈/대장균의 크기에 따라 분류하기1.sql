-- 코드를 작성해주세요
SELECT
    id,
    CASE
        WHEN size_of_colony <= 100 THEN 'LOW'
        WHEN size_of_colony BETWEEN 100 AND 1000 THEN 'MEDIUM'
        ELSE 'HIGH'
        END AS size
FROM ECOLI_DATA
ORDER BY id
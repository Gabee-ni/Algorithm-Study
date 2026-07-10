-- 코드를 작성해주세요
SELECT
    t.year,
    t.max - e.size_of_colony AS year_dev,
    e.id
FROM ecoli_data e
         JOIN (
    SELECT
        YEAR(differentiation_date) AS year,
        MAX(size_of_colony) AS max
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
) t
              ON t.year = YEAR(e.differentiation_date)
ORDER BY t.year, year_dev


-- # 윈도우 함수 사용 ver -> 더 직관적
-- # SELECT
--       #     YEAR(DIFFERENTIATION_DATE) AS YEAR,
-- #     MAX(SIZE_OF_COLONY) OVER (
-- #         PARTITION BY YEAR(DIFFERENTIATION_DATE)
-- #     ) - SIZE_OF_COLONY AS YEAR_DEV,
-- #     ID
-- # FROM ECOLI_DATA
--       # ORDER BY YEAR, YEAR_DEV;
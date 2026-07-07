-- 코드를 작성해주세요
SELECT
    e.id,
    CASE
        WHEN c.cnt IS NOT NULL THEN c.cnt
        ELSE 0
        END AS child_count
FROM ecoli_data e
         LEFT JOIN (
    SELECT
        parent_id,
        COUNT(*) AS cnt
    FROM ecoli_data
    GROUP BY parent_id
) c
                   ON  e.id = c.parent_id


SELECT 
    p.id, 
    COUNT(c.id) as CHILD_COUNT
FROM ecoli_data p
LEFT JOIN ecoli_data c
    ON c.parent_id = p.id
GROUP BY p.id
ORDER BY p.id;
SELECT i.id as ID, 
    n.fish_name as FISH_NAME, 
    i.length as LENGTH
FROM fish_info i
JOIN fish_name_info n
    ON i.fish_type = n.fish_type
WHERE (i.fish_type, i.length) IN (
    SELECT 
        fish_type,
        MAX(length)
    FROM fish_info
    GROUP BY fish_type)
ORDER BY i.id;
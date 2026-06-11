SELECT fi.id, tb.fish_name, tb.length
FROM fish_info fi
         JOIN (
    SELECT i.fish_type, MAX(i.length) AS length, n.fish_name
    FROM fish_info i
             JOIN fish_name_info n ON i.fish_type = n.fish_type
    WHERE length IS NOT NULL
    GROUP BY fish_type
) tb ON fi.length = tb.length AND fi.fish_type = tb.fish_type
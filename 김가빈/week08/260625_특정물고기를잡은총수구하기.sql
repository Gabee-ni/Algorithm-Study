SELECT
    COUNT(*) AS fish_count
FROM fish_info i
         JOIN fish_name_info n
              ON i.fish_type = n.fish_type
WHERE n.fish_name ='BASS' OR n.fish_name ='SNAPPER'
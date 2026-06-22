-- 코드를 입력하세요
SELECT o.animal_id, o.name
FROM animal_outs o
LEFT JOIN animal_ins i ON o.animal_id = i.animal_id
where i.animal_id IS NULL AND o.animal_id IS NOT NULL
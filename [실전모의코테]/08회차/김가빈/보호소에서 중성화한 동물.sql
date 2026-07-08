-- 코드를 입력하세요
SELECT
    o.animal_id,
    o.animal_type,
    o.name
FROM animal_ins i
         JOIN animal_outs o
              ON i.animal_id = o.animal_id
WHERE (i.SEX_UPON_INTAKE NOT LIKE 'Spayed%' AND i.SEX_UPON_INTAKE LIKE 'Intact%')
  AND (o.SEX_UPON_OUTCOME LIKE 'Spayed%' OR o.SEX_UPON_OUTCOME LIKE 'Neutered%' )
ORDER BY animal_id;
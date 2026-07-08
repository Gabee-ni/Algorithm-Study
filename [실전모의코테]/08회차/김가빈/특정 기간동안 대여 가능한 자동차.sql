-- 코드를 입력하세요
SELECT
    c.car_id,
    c.car_type,
    FLOOR( 30 * c.daily_fee * (100 - d.discount_rate) / 100) AS fee
FROM CAR_RENTAL_COMPANY_CAR c
         JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
              ON c.car_type = d.car_type
WHERE c.car_id NOT IN (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date <= '2022-11-30'
      AND end_date >= '2022-11-01'
)
  AND c.car_type IN ('세단', 'SUV')
  AND d.duration_type LIKE '30일%'
  AND FLOOR(30 * c.daily_fee * (100 - d.discount_rate) / 100) BETWEEN 500000 AND 2000000
ORDER BY fee DESC, c.car_type ASC, c.car_id DESC



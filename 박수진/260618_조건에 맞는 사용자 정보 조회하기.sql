SELECT
    u.user_id,
    u.nickname,
    CONCAT(u.city, ' ', u.street_address1, ' ', u.street_address2) AS 전체주소,
    CONCAT(
        SUBSTR(u.tlno, 1, 3), '-',
        SUBSTR(u.tlno, 4, 4), '-',
        SUBSTR(u.tlno, 8)
    ) AS 전화번호
FROM used_goods_user u
WHERE u.user_id IN (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY writer_id
    HAVING COUNT(*) >= 3
)
ORDER BY u.user_id DESC;
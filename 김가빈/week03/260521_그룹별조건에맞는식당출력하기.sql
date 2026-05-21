-- 코드를 입력하세요
SELECT p.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') AS review_date
FROM member_profile p
JOIN rest_review r
    ON p.member_id = r.member_id
WHERE r.member_id = (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
ORDER BY review_date, r.review_text;

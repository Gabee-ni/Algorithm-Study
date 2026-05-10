-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(bs.sales * b.price) as total_sales
from book b
         join author a on b.author_id = a.author_id
         join book_sales bs on b.book_id = bs.book_id
where date_format(bs.sales_date, '%Y-%m') = '2022-01'
group by a.author_name, b.category
order by author_id asc, category desc;
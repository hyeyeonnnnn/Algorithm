SELECT p.product_code, sum(p.price*s.sales_amount) as sales
from product p, offline_sale s
where p.product_id = s.product_id
group by product_code
order by 2 desc, 1;
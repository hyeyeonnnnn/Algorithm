select u.user_id, u.nickname, sum(price) as total_sales
from used_goods_board b inner join used_goods_user u
on b.writer_id = u.user_id
where b.status='DONE'
group by u.user_id, u.nickname
having sum(price) >= 700000
order by sum(price);
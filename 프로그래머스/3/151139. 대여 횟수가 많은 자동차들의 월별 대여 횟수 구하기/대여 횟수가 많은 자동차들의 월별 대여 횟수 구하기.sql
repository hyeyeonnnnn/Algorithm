-- SELECT extract(month from t1.start_date) as MONTH, t1.car_id, count(t1.history_id) as RECORDS
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY t1 
-- INNER JOIN (SELECT car_id
--             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--             WHERE extract(month from start_date) between 8 and 10
--             GROUP BY car_id
--             HAVING count(history_id)>=5
--             ) t2
-- ON t1.car_id = t2.car_id
-- GROUP BY extract(month from t1.start_date), t1.car_id
-- ORDER BY 1, 2 desc
SELECT extract(month from start_date) as MONTH, car_id, count(history_id) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE car_id IN (SELECT c.car_id
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c
                WHERE extract(month from c.start_date) between 8 and 10
                GROUP BY c.car_id
                HAVING count(c.history_id)>=5
                )  AND extract(month from start_date) between 8 and 10
GROUP BY extract(month from start_date), car_id
ORDER BY 1, 2 desc

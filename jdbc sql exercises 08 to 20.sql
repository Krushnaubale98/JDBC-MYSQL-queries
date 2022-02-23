use jdbc;
select FullName from employeedetails where EmpId in (select EmpId from employeesalary where Salary between 5000 and 10000);
SELECT COUNT(*) FROM EmployeeSalary WHERE Project = 'P1';
SELECT Project, count(EmpId) EmpProjectCount FROM EmployeeSalary GROUP BY Project 
ORDER BY EmpProjectCount DESC;


/* tables  
salesman_id  name        city        commission
-----------  ----------  ----------  ----------
5001         James Hoog  New York    0.15
5002         Nail Knite  Paris       0.13
5005         Pit Alex    London      0.11
5006         Mc Lyon     Paris       0.14
5003         Lauson Hen              0.12
5007         Paul Adam   Rome        0.13
table: customer
customer_id  cust_name     city        grade       salesman_id
-----------  ------------  ----------  ----------  -----------
3002         Nick Rimando  New York    100         5001
3005         Graham Zusi   California  200         5002
3001         Brad Guzan    London                  5005
3004         Fabian Johns  Paris       300         5006
3007         Brad Davis    New York    200         5001
3009         Geoff Camero  Berlin      100         5003
3008         Julian Green  London      300         5002
3003         Jozy Altidor  Moscow      200         5007

table: orders
ord_no      purch_amt   ord_date    customer_id  salesman_id
----------  ----------  ----------  -----------  -----------
70001       150.5       2012-10-05  3005         5002
70009       270.65      2012-09-10  3001         5005
70002       65.26       2012-10-05  3002         5001
70004       110.5       2012-08-17  3009         5003
70007       948.5       2012-09-10  3005         5002
70005       2400.6      2012-07-27  3007         5001
70008       5760        2012-09-10  3002         5001
70010       1983.43     2012-10-10  3004         5006
70003       2480.4      2012-10-10  3009         5003
70012       250.45      2012-06-27  3008         5002
70011       75.29       2012-08-17  3003         5007
70013       3045.6      2012-04-25  3002         5001
*/


/* Exercise 8: Write a query to find those customers with their
 name and those salesmen with their name and city who lives in the same city.
*/
select customer.custname,salesman.sname,salesman.scity from salesman,
customer where salesman.scity=customer.city;

/*Exercise 9:  Write a SQL statement to find the names of all customers
along with the salesmen who works for them

*/
select customer.custname,salesman.sname from customer , 
salesman where customer.salesmanid=salesman.salesmanid;

/*Exercise 10: Write a SQL statement that finds out each order number followed by the
 name of the customers who made the order.*/

select customer.custname as "Customer" ,
orders.orderno as "Orderno." 
from orders,salesman,customer
where orders.customerid=customer.customerid
and orders.salesmanid=salesman.salesmanid
;

/* Exercise 11 : Write a SQL statement that sorts out the customer and their grade who made an order.
 Each of the customers must have a grade and served by at least a salesman, who belongs to a city.

*/
select customer.custname as "Customer",
customer.grade as "Grade",
orders.orderno as "Order no"
from orders,salesman,customer
where orders.customerid=customer.customerid and
orders.salesmanid=salesman.salesmanid
and salesman.scity is not null
and customer.grade is not null;

/* Exercise 12 : Write a query that produces all customers with their name, city, salesman and
 commission, who served by a salesman and the salesman works at a rate of the 
 commission within 12% to 14%

*/

select customer.custname as "Customer",customer.city as "City",
salesman.sname as "salesman name",salesman.commission as "salesman commissiin"
from customer ,salesman 
where customer.salesmanid=salesman.salesmanid
and salesman.commission between .12 and .14;
 
 
 /* table
 
 table employees

 EMPLOYEE_ID | FIRST_NAME  | LAST_NAME   | EMAIL    | PHONE_NUMBER       | HIRE_DATE  | JOB_ID     | SALARY   | COMMISSION_PCT | MANAGER_ID | DEPARTMENT_ID |
+-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
|         100 | Steven      | King        | SKING    | 515.123.4567       | 1987-06-17 | AD_PRES    | 24000.00 |           0.00 |          0 |            90 |
|         101 | Neena       | Kochhar     | NKOCHHAR | 515.123.4568       | 1987-06-18 | AD_VP      | 17000.00 |           0.00 |        100 |            90 |
|         102 | Lex         | De Haan     | LDEHAAN  | 515.123.4569       | 1987-06-19 | AD_VP      | 17000.00 |           0.00 |        100 |            90 |
|         103 | Alexander   | Hunold      | AHUNOLD  | 590.423.4567       | 1987-06-20 | IT_PROG    |  9000.00 |           0.00 |        102 |            60 |
|         104 | Bruce       | Ernst       | BERNST   | 590.423.4568       | 1987-06-21 | IT_PROG    |  6000.00 |           0.00 |        103 |            60 |
|         105 | David       | Austin      | DAUSTIN  | 590.423.4569       | 1987-06-22 | IT_PROG    |  4800.00 |           0.00 |        103 |            60 |
|         106 | Valli       | Pataballa   | VPATABAL | 590.423.4560       | 1987-06-23 | IT_PROG    |  4800.00 |           0.00 |        103 |            60 |
|         107 | Diana       | Lorentz     | DLORENTZ | 590.423.5567       | 1987-06-24 | IT_PROG    |  4200.00 |           0.00 |        103 |            60 |
|         108 | Nancy       | Greenberg   | NGREENBE | 515.124.4569       | 1987-06-25 | FI_MGR     | 12000.00 |           0.00 |        101 |           100 |
|         109 | Daniel      | Faviet      | DFAVIET  | 515.124.4169       | 1987-06-26 | FI_ACCOUNT |  9000.00 |           0.00 |        108 |           100 |
|         110 | John        | Chen        | JCHEN    | 515.124.4269       | 1987-06-27 | FI_ACCOUNT |  8200.00 |           0.00 |        108 |           100 |
|         111 | Ismael      | Sciarra     | ISCIARRA | 515.124.4369       | 1987-06-28 | FI_ACCOUNT |  7700.00 |           0.00 |        108 |           100 |
|         112 | Jose Manuel | Urman       | JMURMAN  | 515.124.4469       | 1987-06-29 | FI_ACCOUNT |  7800.00 |           0.00 |        108 |           100 |
|         113 | Luis        | Popp        | LPOPP    | 515.124.4567       | 1987-06-30 | FI_ACCOUNT |  6900.00 |           0.00 |        108 |           100 |
|         114 | Den         | Raphaely    | DRAPHEAL | 515.127.4561       | 1987-07-01 | PU_MAN     | 11000.00 |           0.00 |        100 |            30 |
|         115 | Alexander   | Khoo        | AKHOO    | 515.127.4562       | 1987-07-02 | PU_CLERK   |  3100.00 |           0.00 |        114 |            30 |
|         116 | Shelli      | Baida       | SBAIDA   | 515.127.4563       | 1987-07-03 | PU_CLERK   |  2900.00 |           0.00 |        114 |            30 |
|         117 | Sigal       | Tobias      | STOBIAS  | 515.127.4564       | 1987-07-04 | PU_CLERK   |  2800.00 |           0.00 |        114 |            30 |
|         118 | Guy         | Himuro      | GHIMURO  | 515.127.4565       | 1987-07-05 | PU_CLERK   |  2600.00 |           0.00 |        114 |            30 |
|         119 | Karen       | Colmenares  | KCOLMENA | 515.127.4566       | 1987-07-06 | PU_CLERK   |  2500.00 |           0.00 |        114 |            30 |
|         120 | Matthew     | Weiss       | MWEISS   | 650.123.1234       | 1987-07-07 | ST_MAN     |  8000.00 |           0.00 |        100 |            50 |

table :departments
+---------------+----------------------+------------+-------------+
| DEPARTMENT_ID | DEPARTMENT_NAME      | MANAGER_ID | LOCATION_ID |
+---------------+----------------------+------------+-------------+
|            10 | Administration       |        200 |        1700 |
|            20 | Marketing            |        201 |        1800 |
|            30 | Purchasing           |        114 |        1700 |
|            40 | Human Resources      |        203 |        2400 |
|            50 | Shipping             |        121 |        1500 |
|            60 | IT                   |        103 |        1400 |
|            70 | Public Relations     |        204 |        2700 |
|            80 | Sales                |        145 |        2500 |
|            90 | Executive            |        100 |        1700 |
|           100 | Finance              |        108 |        1700 |
|           110 | Accounting           |        205 |        1700 |
|           120 | Treasury             |          0 |        1700 |
|           130 | Corporate Tax        |          0 |        1700 |
|           140 | Control And Credit   |          0 |        1700 |
|           150 | Shareholder Services |          0 |        1700 |
|           160 | Benefits             |          0 |        1700 |
|           170 | Manufacturing        |          0 |        1700 |
|           180 | Construction         |          0 |        1700 |
|           190 | Contracting          |          0 |        1700 |
|           200 | Operations           |          0 |        1700 |
|           210 | IT Support           |          0 |        1700 |
|           220 | NOC                  |          0 |        1700 |
|           230 | IT Helpdesk          |          0 |        1700 |
|           240 | Government Sales     |          0 |        1700 |
|           250 | Retail Sales         |          0 |        1700 |
|           260 | Recruiting           |          0 |        1700 |
|           270 | Payroll              |          0 |        1700 |
+---------------+----------------------+------------+-------------+
*/

/* Exercise 13 : Write a query to list the department ID and name of 
all the departments where no employee is working.

*/
SELECT * FROM departments 
where DepartmentId not in(select DepartmentId from employees);

/* Exercise 14 : Write a query to get 3 maximum salaries from Employees table.
*/
SELECT distinct Salary from employees a where 3 >= (select count(DISTINCT Salary)
from employees b where b.Salary>=a.Salary) order by a.Salary desc;
 
 /*Exercise 15 : Write a query to get 3 minimum salaries from Employees table.
*/
select distinct Salary from employees a where 3 >= (select count(DISTINCT Salary)
from employees b where b.Salary <= a.Salary)order by a.Salary desc;

/* Exercise 16 : Write a query to find the 4th minimum salary in the employees table
*/
select distinct Salary from employees a where 4=(select count(distinct Salary)
from employees b where a.Salary >=b.salary);

/* Exercise 17 : Write a query to display the employee ID, first name, last name, salary 
of all employees whose salary is above average for their departments.
*/
select EmpId,FName,LName, Salary from employees as a where Salary >
(select avg(Salary)from employees where DepartmentId=a.DepartmentId);

/*Exercise 18 : Write a query to list the number of jobs available in the employees table.
 */
 select count(distinct JobId)
 from employees;
 
 /* Exercise 19 : Write a query to get the minimum salary from employees table..
*/
select distinct Salary from employees a where 0>= (select count(distinct Salary)
 from employees b where a.Salary <b.Salary);
  
  select max(Salary), min(Salary) from employees;
  
  /*Exercise 20 : Write a query to get the total salaries payable to employees .
 */
  select sum(Salary) from employees


/* All the queries are tested in mysql workbench  */
 
# Empoyee Database


<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| test_url | http://localhost:7000 | string |


## Endpoints

* [Employee](#employee)
    1. [Employee Get All](#1-employee-get-all)
    1. [Employee Insert](#2-employee-insert)
    1. [Employee Update](#3-employee-update)
    1. [Employee Delete](#4-employee-delete)
    1. [Salary All Employee](#5-salary-all-employee)
    1. [Employee By Year](#6-employee-by-year)
    1. [Employee By Gender](#7-employee-by-gender)
* [Title](#title)
    1. [Title Get All](#1-title-get-all)
    1. [Title Insert](#2-title-insert)
    1. [Title Update](#3-title-update)
    1. [Title Delete](#4-title-delete)
* [Department](#department)
    1. [Department Get All](#1-department-get-all)
    1. [Department Insert](#2-department-insert)
    1. [Department Update](#3-department-update)
    1. [Department Delete](#4-department-delete)
* [Salary](#salary)
    1. [Salary Get All](#1-salary-get-all)
    1. [Salary Insert](#2-salary-insert)
    1. [Salary Update](#3-salary-update)
    1. [Salary Delete](#4-salary-delete)
* [Department Employee](#department-employee)
    1. [Department Employee Get All](#1-department-employee-get-all)
    1. [Department Employee Insert](#2-department-employee-insert)
    1. [Department Employee Delete](#3-department-employee-delete)
* [Department Manager](#department-manager)
    1. [Department Manager Get All](#1-department-manager-get-all)
    1. [Department Manager Insert](#2-department-manager-insert)
    1. [Department Manager Delete](#3-department-manager-delete)
    1. [All Employee By Department Name](#4-all-employee-by-department-name)

--------



## Employee



### 1. Employee Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/employee/find-all
```



### 2. Employee Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/employee/insert
```



***Body:***

```js        
{
    "id" : "E0007",
    "titleId" : "T0002",
    "birthDate" : "1999-07-27",
    "firstName" : "Muhammad",
    "lastName" : "Jessin Pramanda",
    "gender" : "Laki-laki",
    "hiredDate" : "2022-03-09"
}
```



### 3. Employee Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{test_url}}/employee/update/E0001
```



***Body:***

```js        
{
    "firstName" : "Aprilla",
    "lastName" : "Firdausya Nugraha",
    "gender" : "Perempuan"
}
```



### 4. Employee Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{test_url}}/employee/delete/E0006
```



### 5. Salary All Employee



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/employee/find-all-salary
```



### 6. Employee By Year



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/employee/2022
```



### 7. Employee By Gender



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/employee/gender/Laki-laki
```



## Title



### 1. Title Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/title/find-all
```



### 2. Title Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/title/insert
```



***Body:***

```js        
{
    "id" : "T0008",
    "titleName" : "Manager"
}
```



### 3. Title Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{test_url}}/title/update/T0008
```



***Body:***

```js        
{
    "titleName" : "CEO"
}
```



### 4. Title Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{test_url}}/title/delete/T0008/De
```



## Department



### 1. Department Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/department/find-all
```



### 2. Department Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/department/insert
```



***Body:***

```js        
{
    "id" : "D0009",
    "departmentName" : "Customer Service"
}
```



### 3. Department Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{test_url}}/department/update/D0009
```



***Body:***

```js        
{
    "departmentName" : "Customer Service"
}
```



### 4. Department Delete



***Endpoint:***

```bash
Method: DELETE
Type: RAW
URL: {{test_url}}/department/delete/D0009
```



## Salary



### 1. Salary Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/salary/find-all
```



### 2. Salary Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/salary/insert
```



***Body:***

```js        
{
    "employeeId" : "E0003",
    "salary" : "6000000"
}
```



### 3. Salary Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{test_url}}/salary/update/E0001
```



***Body:***

```js        
{
    "salary" : "4650000"
}
```



### 4. Salary Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{test_url}}/salary/delete/E0003
```



## Department Employee



### 1. Department Employee Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/departmentemployee/find-all
```



### 2. Department Employee Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/departmentemployee/insert
```



***Body:***

```js        
{
    "employeeId" : "E0001",
    "departmentId" : "D0005"
}
```



### 3. Department Employee Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{test_url}}/departmentemployee/delete/E0001
```



## Department Manager



### 1. Department Manager Get All



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/departmentmanager/find-all
```



### 2. Department Manager Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{test_url}}/departmentmanager/insert
```



***Body:***

```js        
{
    "employeeId" : "E0001",
    "departmentId" : "D0005"
}
```



### 3. Department Manager Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{test_url}}/departmentmanager/delete/E0002
```



### 4. All Employee By Department Name



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{test_url}}/departmentemployee/Development
```



---
[Back to top](#empoyee-database)

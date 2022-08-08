create database EmployeeDB
create table Titles (
	TitleID varchar(5) NOT NULL PRIMARY KEY,
	TitleName varchar(50) NOT NULL
);

create table Departments (
	DepartmentID varchar(5) NOT NULL PRIMARY KEY,
	DepartmentName varchar(50) NOT NULL
);

create table Employees (
	EmployeeID varchar(5) NOT NULL PRIMARY KEY,
	TitleID varchar(5) NOT NULL,
	BirthDate date NOT NULL,
	FirstName varchar(20) NOT NULL,
	LastName varchar(20),
	Gender varchar(10) NOT NULL,
	HiredDate date NOT NULL,
	FOREIGN KEY (TitleID) REFERENCES Titles(TitleID)
);

create table DepartmentEmployee (
	EmployeeID varchar(5) PRIMARY KEY,
	DepartmentID varchar(5),
	FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
	FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);

create table DepartmentManager (
	EmployeeID varchar(5) NOT NULL PRIMARY KEY,
	DepartmentID varchar(5) NOT NULL,
	FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID),
	FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

drop table DepartmentManager

create table Salaries (
	EmployeeID varchar(5) NOT NULL PRIMARY KEY,
	Salary int NOT NULL,
	FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);
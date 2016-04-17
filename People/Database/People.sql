-- Database: "People"

-- DROP DATABASE "People";

CREATE DATABASE "People"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

--Can change owner as per Server if needed

--Creating the tables
CREATE TABLE Person
(
PersonID  SERIAL Primary Key,
firstNames Varchar(30),
surname Varchar(50),
Emails Varchar(50),
OrganizationID int,
ResearchGroupID int,
ResearchCategoryID int
);

CREATE TABLE Organization
(
OrganizationID SERIAL Primary Key,
names Varchar(50)
);


CREATE TABLE ResearchGroup
(
ResearchGroupID SERIAL Primary Key,
Name Varchar(50),
StartDate Date,
EndDate Date
);

CREATE TABLE ResearcherCategory
(
ResearchCategoryID SERIAL Primary Key,
Name Varchar(50),
EffectiveDate Date
);

--Adding the Foreign key constraints to the Person table to like to Organization, ResearchGroup etc.
Alter Table Person
ADD CONSTRAINT fk_OrganizationID  FOREIGN KEY (OrganizationID ) REFERENCES Organization(OrganizationID);

Alter Table Person
ADD CONSTRAINT fk_ResearchGroupID FOREIGN KEY (ResearchGroupID ) REFERENCES ResearchGroup(ResearchGroupID);

Alter Table Person
ADD CONSTRAINT fk_ResearchCategoryID FOREIGN KEY (ResearchCategoryID ) REFERENCES ResearcherCategory(ResearchCategoryID);

--TODO: Ask about multiple ResearchGroup linking, as currently only supports one ResearchGroup
--TOD: Ask about Email entity 


--Adding new Users, Organizations and ResearchGroups, ResearchCategorys

INSERT INTO Organization(names)
VALUES('Test Organization');

--Select * from Organization

INSERT INTO ResearcherCategory
(Name,EffectiveDate) VALUES('Test Research Category','2016-01-01');

--Select * from ResearcherCategory

INSERT INTO ResearchGroup
(Name ,StartDate,EndDate)
VALUES('Test Research Group Name','2016-01-01','2016-12-31');

--Select * from ResearchGroup

INSERT INTO Person
(firstNames,surname,Emails,OrganizationID,ResearchGroupID,ResearchCategoryID)
VALUES('Test Person', 'Test Surname','test@test.co.za',1,1,1);

--Select * from Person


--SELECT Person.firstNames, Person.surname, Person.Emails, Organization.names, ResearcherCategory.Name,ResearchGroup.Name from Person, Organization, ResearcherCategory, ResearchGroup



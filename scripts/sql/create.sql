-- DROP DATABASE koala;

/*CREATE DATABASE koala
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;*/

-- DROP TABLE exp_category;

CREATE TABLE exp_category
(
	ec_id bigint NOT NULL,
	title varchar(100) NOT NULL,
	CONSTRAINT pk_exp_category PRIMARY KEY(ec_id)
)
WITHOUT OIDS;

-- DROP SEQUENCE exp_category_seq

CREATE SEQUENCE exp_category_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

-- DROP TABLE exp_expense;

CREATE TABLE exp_expense
(
	exp_id bigint NOT NULL,
	ec_id bigint NOT NULL,
	occured timestamptz NOT NULL,
	amount bigint NOT NULL,
	description varchar(200),
	CONSTRAINT positive_exp_expense_amount CHECK (amount > 0),
	CONSTRAINT pk_exp_expense PRIMARY KEY(exp_id),
	CONSTRAINT fk_exp_expense_category FOREIGN KEY(ec_id) 
		REFERENCES exp_category(ec_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITHOUT OIDS;

-- DROP SEQUENCE exp_expense_seq

CREATE SEQUENCE exp_expense_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

-- DROP TABLE inc_category;

CREATE TABLE inc_category
(
	ic_id bigint NOT NULL,
	title varchar(100) NOT NULL,
	CONSTRAINT pk_inc_category PRIMARY KEY(ic_id)
)
WITHOUT OIDS;

-- DROP SEQUENCE inc_category_seq

CREATE SEQUENCE inc_category_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

-- DROP TABLE inc_income;

CREATE TABLE inc_income
(
	inc_id bigint NOT NULL,
	ic_id bigint NOT NULL,
	occured timestamptz NOT NULL,
	amount bigint NOT NULL,
	description varchar(200),
	CONSTRAINT positive_inc_income_amount CHECK (amount > 0),
	CONSTRAINT pk_inc_income PRIMARY KEY(inc_id),
	CONSTRAINT fk_inc_income_category FOREIGN KEY(ic_id)
		REFERENCES inc_category(ic_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITHOUT OIDS;

-- DROP SEQUENCE inc_income_seq

CREATE SEQUENCE inc_income_seq
	INCREMENT 1
	MINVALUE 1
	START 1;
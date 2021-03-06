CREATE DATABASE testdatabase
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


CREATE TABLE public."CATEGORY"
(
    "CATEGORYID" integer NOT NULL,
    "CATEGORYCODE" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "CATEGORYNAME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "PARENTCATEGORYID" integer NOT NULL,
    CONSTRAINT "CATEGORY_pkey" PRIMARY KEY ("CATEGORYID"),
    CONSTRAINT "CATEGORYCODE_UNIQUE" UNIQUE ("CATEGORYCODE"),
    CONSTRAINT "CATEGORYNAME_UNIQUE" UNIQUE ("CATEGORYNAME"),
    CONSTRAINT "PARENTCATEGORYID_FKEY" FOREIGN KEY ("PARENTCATEGORYID")
        REFERENCES public."CATEGORY" ("CATEGORYID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."CATEGORY"
    OWNER to postgres;
	
	

CREATE TABLE public."CREDITSOURCE"
(
    "CREDITSOURCEID" integer NOT NULL,
    "CREDITSOURCENAME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "CREDITSOURCECODE" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "PARENTCREDITSOURCEID" integer,
    CONSTRAINT "CREDITSOURCE_pkey" PRIMARY KEY ("CREDITSOURCEID"),
    CONSTRAINT "CREDITSOURCECODE_UNIQUE" UNIQUE ("CREDITSOURCECODE"),
    CONSTRAINT "CREDITSOURCENAME_UNIQUE" UNIQUE ("CREDITSOURCENAME"),
    CONSTRAINT "PARENTCREDITSOURCEID_FKEY" FOREIGN KEY ("PARENTCREDITSOURCEID")
        REFERENCES public."CREDITSOURCE" ("CREDITSOURCEID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."CREDITSOURCE"
    OWNER to postgres;
	
	

CREATE TABLE public."TRANSACTION"
(
    "TRANSACTIONID" integer NOT NULL,
    "CREDIT/DEBIT" character varying(6) COLLATE pg_catalog."default" NOT NULL,
    "CATEGORYID" integer NOT NULL,
    "TRANSACTIONDATE" time with time zone NOT NULL,
    "CREDITSOURCEID" integer NOT NULL,
    CONSTRAINT "TRANSACTION_pkey" PRIMARY KEY ("TRANSACTIONID"),
    CONSTRAINT "TRANSACTION_CATEGORYID_fkey" FOREIGN KEY ("CATEGORYID")
        REFERENCES public."CATEGORY" ("CATEGORYID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "TRANSACTION_CREDITSOURCEID_fkey" FOREIGN KEY ("CREDITSOURCEID")
        REFERENCES public."CREDITSOURCE" ("CREDITSOURCEID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."TRANSACTION"
    OWNER to postgres;
	
	

CREATE TABLE public."USERDETAILS"
(
    "USERID" integer NOT NULL,
    "FIRSTNAME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "LASTNAME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "USERNAME" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "PASSWORD" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "EMAIL" character varying(255) COLLATE pg_catalog."default",
    "TELEPHONENUM" character varying(12) COLLATE pg_catalog."default",
    "CREATEDON" time with time zone,
    CONSTRAINT "USERDETAILS_pkey" PRIMARY KEY ("USERID"),
    CONSTRAINT "USERNAME_UNIQUE" UNIQUE ("USERNAME")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."USERDETAILS"
    OWNER to postgres;
    
    
CREATE SEQUENCE hibernate_sequence START 1;
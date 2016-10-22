/**
 * SQL Parser grammar for ANTLR 4.
 *
 * This file is part of JEJDBC 
 * https://github.com/perbone/jejdbc/
 * 
 * Copyright 2013-2016 Paulo Perbone
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
 
grammar sql;

statement_list ::= 
        statement:s1       
      | statement_list SEMI_COLON statement:s2
      | error
      ;

statement ::=
        SELECT select_union:s
      | UPDATE update:u
      | INSERT insert:i
      | CREATE TABLE create_table:c
      | CREATE VIEW create_view:c with_check_option:o
      | CREATE INDEX create_index:c
      | CREATE UNIQUE INDEX create_index:c
      | DELETE del:d
      | DROP TABLE drop_table:d
      | DROP VIEW drop_view:d
      | DROP INDEX drop_index:d
      ;
      
top ::=
        /* Nothing */
      | TOP TYPE_INTEGER:i
      ;
                     
references_col_list ::=
    /* Nothing */
      | OPEN_PAREN col_list:c CLOSE_PAREN
      ;

references_match ::=
        /* Nothing */
      | MATCH FULL
      | MATCH PARTIAL
      ;

on_update ::=
        ON UPDATE CASCADE
      | ON UPDATE SET OP_NULL
      | ON UPDATE SET DEFAULT
      | ON UPDATE NO ACTION
      ;

on_delete ::=
        ON DELETE CASCADE
      | ON DELETE SET OP_NULL
      | ON DELETE SET DEFAULT
      | ON DELETE NO ACTION
 ;
 
references_on_clause ::=
        /* Nothing */
      | on_update:u
      | on_delete:d
      | on_update:u on_delete:d
      | on_delete:d on_update:u
      ;
          
deferred ::=
        /* Nothing */
      | INITIALLY DEFERRED DEFERRABLE
      | INITIALLY DEFERRED NOT DEFERRABLE
      | INITIALLY IMMEDIATE DEFERRABLE
      | INITIALLY IMMEDIATE NOT DEFERRABLE
      | NOT DEFERRABLE INITIALLY DEFERRED
      | DEFERRABLE INITIALLY DEFERRED
      | NOT DEFERRABLE INITIALLY IMMEDIATE
      | DEFERRABLE INITIALLY IMMEDIATE     
      ;      

select_union ::=
        select:s
      | select:s UNION union_qual:q SELECT select_union:u
      ;

union_qual ::=
        /* Nothing */
      | ALL
      ;

select ::=
        select_cols:c
| select_cols:c FROM table_list:t where:w group_by:g having:h 
order_by:o for_update:f
      ;

update ::=
        id_list_for_update:i SET set_list:s where:w
      ;

insert ::=
        INTO id_list:i OPEN_PAREN col_list:c CLOSE_PAREN VALUES 
OPEN_PAREN value_list:v CLOSE_PAREN
      | INTO id_list:i VALUES OPEN_PAREN value_list:v CLOSE_PAREN
      | INTO id_list:i OPEN_PAREN col_list:c CLOSE_PAREN VALUES 
OPEN_PAREN SELECT select_union:s CLOSE_PAREN
      | INTO id_list:i VALUES OPEN_PAREN SELECT select_union:s 
CLOSE_PAREN
      ;

create_table ::=
        id_list:i OPEN_PAREN table_col_list:c CLOSE_PAREN
      | id_list:i STRING:s OPEN_PAREN table_col_list:c CLOSE_PAREN
      ;     
      
create_view ::=
        id_list:i OPEN_PAREN col_list:c CLOSE_PAREN AS SELECT select:s
      | id_list:i AS SELECT select:s
      ;
      
with_check_option ::=
        /* Nothing */
      | WITH CHECK OPTION
      | WITH LOCAL CHECK OPTION
      | WITH CASCADE CHECK OPTION
      ;      

create_index ::=
        id_list:i1 ON id_list:i2 OPEN_PAREN index_col_list:c 
CLOSE_PAREN
      ;

del ::=
        FROM id_list:l where:w
      ;

drop_table ::=
        id_list:l 
      | id_list:l CASCADE
      | id_list:l CASCADE CONSTRAINTS
      ;

clone_database ::=
        id:new_db_name STRING:db_dir
      ;

drop_view ::=
        id_list:l
      ;

drop_index ::=
        id_list:l
      ;

/* INDEX COL LIST (for CREATE INDEX) */
index_col_list ::=
        index_col:c
      | index_col_list:l COMMA index_col:c
      ;

index_col ::=
        id_list:i asc:a
      ;

/* TABLE COL LIST (for CREATE TABLE) */
table_col_list ::=
        table_col:c
      | table_col_list:l COMMA table_col:c
      ;

table_col ::=
        id:i col_type:t col_qual:q
      | id:i col_type:t OPEN_PAREN TYPE_INTEGER:ti CLOSE_PAREN 
col_qual:q
      | id:i col_type:t OPEN_PAREN TYPE_INTEGER:t1 COMMA 
TYPE_INTEGER:t2 CLOSE_PAREN col_qual:q
      |
        id:i col_type:t table_constraint:c
      | id:i col_type:t OPEN_PAREN TYPE_INTEGER:ti CLOSE_PAREN 
table_constraint:c
      | id:i col_type:t OPEN_PAREN TYPE_INTEGER:p1 COMMA 
TYPE_INTEGER:p2 CLOSE_PAREN table_constraint:c
      | alter_table_constraint:c
      | PRIMARY OPEN_PAREN col_list:l CLOSE_PAREN
      | PRIMARY KEY OPEN_PAREN col_list:l CLOSE_PAREN
      | FOREIGN OPEN_PAREN col_list:l CLOSE_PAREN
      | FOREIGN KEY OPEN_PAREN col_list:l CLOSE_PAREN
      | UNIQUE OPEN_PAREN col_list:l CLOSE_PAREN
      | UNIQUE KEY OPEN_PAREN col_list:l CLOSE_PAREN
      | NOT OP_NULL OPEN_PAREN col_list:l CLOSE_PAREN
      ;


col_type ::=
        CHAR
      | CHARACTER
      | CHARACTER VARYING
      | CHAR VARYING
      | VARCHAR
      | LONG VARCHAR
      | LONG CHAR VARYING
      | FLOAT
      | DOUBLE
      | REAL
      | BYTE
      | SMALLINT
      | INTEGER
      | UNSIGNED BYTE
      | UNSIGNED SMALLINT
      | UNSIGNED INTEGER
      | TIMESTAMP
      | BIT
      | DECIMAL
      | NUMERIC
      | DATE
      ;

col_qual ::=
        /* Nothing */
      | PRIMARY
      | PRIMARY KEY
      | FOREIGN
      | FOREIGN KEY
      | UNIQUE
      | UNIQUE KEY
      | NOT OP_NULL
      | OP_NULL
      ;

table_constraint ::=
        CONSTRAINT id:i table_constraint_type:t
      ;

table_constraint_type ::=
      PRIMARY KEY
      | UNIQUE
      | CHECK OPEN_PAREN boolean:b CLOSE_PAREN
      | REFERENCES id_list:i references_col_list:l references_match:m 
references_on_clause:o deferred:d
      ;       

col_list ::=
        id_list:i
      | col_list:c COMMA id_list:i
      ;

set_list ::=
        set:s
      | set_list:l COMMA set:s
      ;

set ::=
        id_list:i EQ OP_NULL
      | id_list:i EQ expression:e
      ;

select_cols ::=
        select_qual:q top:t select_list:l 
      | select_qual:q top:t ASTERISK
      ;

select_qual ::=
        /* Nothing */
      | ALL
      | DISTINCT
      ;

select_list ::=
        select_item:i
      | select_list:l COMMA select_item:i
      ;

select_item ::=
        expression:e
      | expression:e id_for_select:i
      | expression:e AS id:i
      | expression:e AS STRING:s
      | expression:e STRING:s
      ;

expression ::=
        expression:e PLUS times:t
      | expression:e MINUS times:t
      | times:t
      ;

times ::=
        times:t ASTERISK neg:n
      | times:t DIV neg:n
      | neg:n
      ;

neg ::=
        term:t
      | PLUS term:t
      | MINUS term:t
      ;

term ::=
        OPEN_PAREN expression:e CLOSE_PAREN
      | col_ref:r
      | simple_term:t
      | scalar:s
      ;

col_ref ::=    
        id_list_for_col:l
      | id_list_for_col:l OPEN_BRACE expression:e CLOSE_BRACE
      | id_for_func:i OPEN_PAREN func_qual:q func_arg:a CLOSE_PAREN
      | IFF OPEN_PAREN boolean:b COMMA expression:e1 COMMA 
expression:e2 CLOSE_PAREN
      | CAST OPEN_PAREN expression:e1 AS id_for_cast:t1 CLOSE_PAREN
      | CONVERT OPEN_PAREN expression:e1 COMMA id:t1 CLOSE_PAREN
      | NULLIF OPEN_PAREN expression:e1 COMMA expression:e2 CLOSE_PAREN
      | COALESCE OPEN_PAREN func_arg:a CLOSE_PAREN
      | CASE when_list:w END
      | CASE when_list:w ELSE expression:e END
      | CASE expression:e1 when_expression_list:w END
      | CASE expression:e1 when_expression_list:w ELSE expression:e2 
END
      ;

when_list ::=
        WHEN boolean:b THEN expression:e
      | when_list:w WHEN boolean:b THEN expression:e
      ;

when_expression_list ::=
        WHEN expression:e1 THEN expression:e2
      | when_expression_list:w WHEN expression:e1 THEN expression:e2
      ;

func_qual ::=
        /* Nothing */
      | ALL
      | DISTINCT
      ;

simple_term ::=
        real:r
      | STRING:s
      | QUESTION
      | DATABASE OPEN_PAREN CLOSE_PAREN
      | DATABASE
      | USER OPEN_PAREN CLOSE_PAREN
      | USER
      | date:d
      ;

real ::=
        TYPE_INTEGER:i
      | TYPE_FLOAT:f
      | TYPE_BIG_INT:b
      ;

scalar ::=
        func:f
      ;

func ::=
        OPEN_CURLY FN fn:f CLOSE_CURLY
      ;

fn ::=
        id:i OPEN_PAREN func_arg:a CLOSE_PAREN
      ;

func_arg ::=
        /* Nothing */
      | ASTERISK
      | func_args:a
      ;

func_args ::=
        expression:e
      | func_args:a COMMA expression:e
      ;

date ::=
        OPEN_CURLY OP_D STRING:s CLOSE_CURLY
      | OPEN_CURLY OP_TS STRING:s CLOSE_CURLY 
      ;

for_update ::=
 /* Nothing */
      | FOR UPDATE 
      | FOR UPDATE OF for_update_column_list:l
      ;

for_update_column_list ::=
   id_list:l
      | for_update_column_list:l1 COMMA id_list:l2
      ;


/* Helper for table items. */
table_list ::=
        table_list_item:i
      | table_list:l COMMA table_list_item:i
      ;

table_list_item ::=
        table_ref:r
      | outer_join:o
      | oj:o
      | OPEN_PAREN oj:o CLOSE_PAREN
      ;
         

table_ref ::=
        id_list:l
      | id_list:l id_for_table:i
      | id_list:l AS id_for_table:i
      ;

outer_join ::=
        OPEN_CURLY OJ oj:o CLOSE_CURLY
      ;

oj ::=
        table_list_item:t1 LEFT OUTER JOIN table_list_item:t2 
ON boolean:b
      | table_list_item:t1 RIGHT OUTER JOIN table_list_item:t2 
ON boolean:b
      | table_list_item:t1 LEFT JOIN table_list_item:t2 ON boolean:b
      | table_list_item:t1 RIGHT JOIN table_list_item:t2 ON boolean:b
      | table_list_item:t1 FULL OUTER JOIN table_list_item:t2 
ON boolean:b
      | table_list_item:t1 FULL JOIN table_list_item:t2 ON boolean:b
      | table_list_item:t1 INNER JOIN table_list_item:t2 ON boolean:b
      ;

where ::=
        /* Nothing */
      | WHERE boolean:b
      | WHERE CURRENT OF id:i
      ;

group_by ::=
        /* Nothing */
      | GROUP BY group_by_list:g
      ;

group_by_list ::=
        expression:e
      | group_by_list:g COMMA expression:e
      ;

having ::=
        /* Nothing */
      | HAVING boolean:b
      ;

order_by ::=
        /* Nothing */
      | ORDER BY order_by_list:l
      ;

order_by_list ::=
        order_by_item:i
      | order_by_list:l COMMA order_by_item:i
      ;

order_by_item ::=
        expression:e asc:a
      ;

asc ::=
        /* Nothing */
      | ASC | DESC
      ;

boolean ::=
        and:a
      | and:a OR boolean:b
      ;

and ::=
        not:n
      | not:n AND and:a
      ;

not ::=
        comparison:c
      | NOT comparison:c
      ;

comparison ::=
        OPEN_PAREN boolean:b CLOSE_PAREN
      | col_ref:r IS OP_NULL
      | col_ref:r IS NOT OP_NULL
      | expression:e1 LIKE expression:e2
      | expression:e1 NOT LIKE expression:e2
      | expression:e IN OPEN_PAREN value_list:v CLOSE_PAREN
      | expression:e NOT IN OPEN_PAREN value_list:v CLOSE_PAREN
      | expression:e1 op:o expression:e2
      | expression:e1 op:o OPEN_PAREN SELECT select_union:s CLOSE_PAREN
      | EXISTS OPEN_PAREN SELECT select_union:s CLOSE_PAREN
      | expression:e op:o1 select_op:o2 OPEN_PAREN SELECT 
select_union:s CLOSE_PAREN
      | expression:e IN OPEN_PAREN SELECT select_union:s CLOSE_PAREN
      | expression:e NOT IN OPEN_PAREN SELECT select_union:s 
CLOSE_PAREN
      | expression:e1 BETWEEN expression:e2 AND expression:e3
      | expression:e1 NOT BETWEEN expression:e2 AND expression:e3
      ;

select_op ::=
        ALL | SOME | ANY
      ;

op ::=
        GREATER_THAN | GREATER_THAN_EQ | LESS_THAN
      | LESS_THAN_EQ | EQ | NOT_EQ
      ;

value_list ::=
        OP_NULL
      | expression:e
      | value_list:l COMMA OP_NULL
      | value_list:l COMMA expression:e
      ;

id_common ::=
        ID:i
      | BY | ASC | DESC | OJ | OUTER | JOIN | FN | OR
      | AND | OP_D | OP_TS | UPDATE | INSERT | INTO | VALUES
      | CREATE | CHAR | VARYING | VARCHAR | FLOAT | DOUBLE
      | REAL | BYTE | SMALLINT | INTEGER | UNSIGNED | DATE
      | KEY | VIEW | INDEX | DELETE | DROP | PRIMARY | FOREIGN
      | UNIQUE | BETWEEN | LONG | THEN | ELSE | END
      | CURRENT | OF | ACTION | PARTIAL | MATCH
      ;

id_for_func ::=
        id_common:i
      | TABLE | AS | FROM | WHERE | HAVING | ORDER | LEFT
      | RIGHT | INNER | FULL | ON | GROUP | SET | UNION
      ;

id_for_col ::=
        id_for_func:i
      | IFF | CONVERT | CAST | NULLIF | COALESCE
      ;

id_for_table ::=
        id_common:i
      | TABLE | AS | FROM | ALL | SOME | DISTINCT | USER | NOT 
| IS | LIKE | IN | SELECT | OP_NULL | EXISTS | ANY | SET
      ;

id_for_select ::=
        id_common:i
      | TABLE | WHERE | ALL | SOME | DISTINCT | USER | HAVING
      | ORDER | LEFT | RIGHT | INNER | FULL | ON | GROUP | NOT
      | IS | LIKE | IN | SELECT | OP_NULL | EXISTS | ANY | SET
      | IFF | CONVERT | CAST | NULLIF | COALESCE | CASE | WHEN
      ;

id_for_update ::=
        id_common:i
      | TABLE | AS | FROM | WHERE | ALL | SOME | DISTINCT | USER
      | HAVING | ORDER | LEFT | RIGHT | INNER | FULL | ON | GROUP
      | NOT | IS | LIKE | IN | SELECT | OP_NULL | EXISTS | ANY
      | UNION | IFF | CONVERT | CAST | NULLIF | COALESCE | CASE
      | WHEN
      ;

id ::=
        id_common:i
      | TABLE | AS | FROM | WHERE | ALL | SOME | DISTINCT | USER
      | HAVING | ORDER | LEFT | RIGHT | INNER | FULL | ON | GROUP
      | NOT | IS | LIKE | IN | SELECT | OP_NULL | EXISTS | ANY
      | SET | UNION | IFF | CONVERT | CAST | NULLIF | COALESCE
      | CASE | WHEN
      ;

id_for_cast ::=
        id_common:i
      | NUMERIC | DECIMAL | BIT
      ;
      
id_list ::=
        id:i
      | id_list:l DOT id:i
      ;
            
id_list_for_col ::=
        id_for_col:i
      | id_list_for_col:l DOT id_for_col:i
      | id_list_for_col:l DOT ASTERISK
      ;      
      
id_list_for_update ::=
        id_for_update:i
      | id_list_for_update:l DOT id_for_update:i
      ;   

id_list_common ::=
        id_common:i
      | id_list_common:l DOT id_common:i
      ;
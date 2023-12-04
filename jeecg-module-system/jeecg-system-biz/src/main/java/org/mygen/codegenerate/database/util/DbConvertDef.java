package org.mygen.codegenerate.database.util;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public interface DbConvertDef {
    String a = "Y";
    String b = "N";
    String c = "jdbc:";
    String d = "mysql";
    String e = "oracle";
    String f = "sqlserver";
    String g = "postgresql";
    String h = "dm";
    String i = "hsqldb";
    String j = "h2";
    String k = "phoenix";
    String l = "mariadb";
    String m = "sqlite";
    String n = "herddb";
    String o = "oracle9i";
    String p = "db2";
    String q = "informix";
    String r = "informix-sqli";
    String s = "sqlserver2012";
    String t = "derby";
    String u = "edb";
    String v = "oscar";
    String w = "kingbase";
    String x = "clickhouse";
    String y = "highgo";
    String z = "xugu";
    String A = "zenith";
    String B = "polardb";
    String C = "select column_name,data_type,column_comment,numeric_precision,numeric_scale,character_maximum_length,is_nullable nullable from information_schema.columns where table_name = {0} and table_schema = {1} order by ORDINAL_POSITION";
    String D = " select colstable.column_name column_name, colstable.data_type data_type, commentstable.comments column_comment, colstable.Data_Precision column_precision, colstable.Data_Scale column_scale,colstable.Char_Length,colstable.nullable from user_tab_cols colstable  inner join user_col_comments commentstable  on colstable.column_name = commentstable.column_name  where colstable.table_name = commentstable.table_name  and colstable.table_name = {0}";
    String E = "select distinct cast(a.name as varchar(50)) column_name,  cast(b.name as varchar(50)) data_type,  cast(e.value as NVARCHAR(200)) comment,  cast(ColumnProperty(a.object_id,a.Name,'''Precision''') as int) num_precision,  cast(ColumnProperty(a.object_id,a.Name,'''Scale''') as int) num_scale,  a.max_length,  (case when a.is_nullable=1 then '''y''' else '''n''' end) nullable,column_id   from sys.columns a left join sys.types b on a.user_type_id=b.user_type_id left join (select top 1 * from sys.objects where type = '''U''' and name ={0}  order by name) c on a.object_id=c.object_id left join sys.extended_properties e on e.major_id=c.object_id and e.minor_id=a.column_id and e.class=1 where c.name={0} order by a.column_id";
    String F = "select icm.column_name as field,icm.udt_name as type,fieldtxt.descript as comment, icm.numeric_precision_radix as column_precision ,icm.numeric_scale as column_scale ,icm.character_maximum_length as Char_Length,icm.is_nullable as attnotnull  from information_schema.columns icm, (SELECT A.attnum,( SELECT description FROM pg_catalog.pg_description WHERE objoid = A.attrelid AND objsubid = A.attnum ) AS descript,A.attname \tFROM pg_catalog.pg_attribute A WHERE A.attrelid = ( SELECT oid FROM pg_class WHERE relname = {0} ) AND A.attnum > 0 AND NOT A.attisdropped  ORDER BY\tA.attnum ) fieldtxt where icm.table_name={1} and fieldtxt.attname = icm.column_name";
    String G = "select distinct table_name from information_schema.columns where table_schema = {0}";
    String H = " select distinct colstable.table_name as  table_name from user_tab_cols colstable order by colstable.table_name";
    String I = "select distinct c.name as  table_name from sys.objects c where c.type = 'U' ";
    String J = "select tablename from pg_tables where schemaname in( {0} )";
}

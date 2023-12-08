package org.jeecg.codegenerate;

import org.mygen.codegenerate.database.DbReadTableUtil;
import org.mygen.codegenerate.generate.impl.CodeGenerateOne;
import org.mygen.codegenerate.generate.pojo.TableVo;
import org.mygen.codegenerate.generate.util.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MyGen {

    public static void main(String[] args) {
        HashSet<String> tableNames = new HashSet<>();
        tableNames.add("jw_network_disk");
//        tableNames.add("expos_social_project_detail_copy1");
//        tableNames.add("abc");
//        tableNames.add("abds");
        String entityPackage = "jw";

        // Map<表名, 注释>, 自定义注释Map
        Map<String, String> commentMap = new HashMap<>();
        commentMap.put("demo", "demo注释修改");

        try {
            for (String tableName : tableNames) {
                Map<String, String> map = DbReadTableUtil.readTableDetail(tableName);
                if (map != null) {
                    TableVo tempTable = new TableVo();
                    tempTable.setTableName(tableName);
//                    tempTable.setPrimaryKeyPolicy("uuid");
                    tempTable.setEntityPackage(entityPackage);
                    tempTable.setEntityName(f.convertHumpFull(tableName));
                    tempTable.setFtlDescription(map.get("comment"));

                    String comment = commentMap.get(tableName);
                    if (comment != null) {
                        tempTable.setFtlDescription(comment);
                    }
                    // main使用online模板, 需要指定 default.one
                    new CodeGenerateOne(tempTable).generateCodeFile("default.one");
                    new CodeGenerateOne(tempTable).generateCodeFile(null);
                }
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        System.exit(0);
    }
}

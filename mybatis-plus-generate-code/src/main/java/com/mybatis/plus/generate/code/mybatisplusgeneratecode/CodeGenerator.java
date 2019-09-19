package com.mybatis.plus.generate.code.mybatisplusgeneratecode;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {

    public static String scanner(String content) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入" + content + ":");
        System.out.println(stringBuilder.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + content + "！");
    }

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String path = System.getProperty("user.dir");
        globalConfig.setOutputDir(path + "/src/main/java");
        globalConfig.setAuthor("zhouzhonghui");
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://192.168.50.60:3306/cgdb_report?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("000000");
        autoGenerator.setDataSource(dataSourceConfig);
        //包信息配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("com.example.cn");
        autoGenerator.setPackageInfo(packageConfig);
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.example.cn.common.BaseEntity");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setSuperControllerClass("com.example.cn.common.BaseController");
        strategyConfig.setInclude(scanner("表名，多个表用逗号分隔").split(","));
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();


    }

}

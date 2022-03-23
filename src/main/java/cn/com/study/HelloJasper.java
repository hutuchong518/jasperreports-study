package cn.com.study;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HelloJasper {

    public static void main(String[] args) {
        new HelloJasper();
    }

    public HelloJasper() {
        try {
            //System.out.println(getClass().getResource(getClass().getResource("../../../../resources/report/test.jasper").getPath()));
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(getClass().getResource("../../../../resources/report/test.jasper").getPath());
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("I:\\workspace\\workspace-github\\jasperreports-study\\src\\main\\resources\\report\\test.jasper");
            System.out.println("start...");
            //System.out.println(getClass().getResource("/"));
            //System.out.println(System.getProperty("java.class.path"));

            //windows 可以
            //System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            //JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(Thread.currentThread().getContextClassLoader().getResource("").getPath()+"report/test.jasper");

            File f=new File("//");
            System.out.println("根目录："+f.getAbsolutePath());

            //linux
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("/test.jasper");


            //表头数据项
            HashMap<String, Object> header = new HashMap<>();
            header.put("xm", "张三");

            //列表数据项
            List<HashMap> list = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                HashMap<String, String> item = new HashMap<>();
                item.put("zsxm", "养老保险");
                item.put("zspm", "养老保险公司缴纳部分");
                item.put("zszm", "养老保险基金收入");
                item.put("fkssqq", "2022-03");
                item.put("fkssqz", "2022-03");
                list.add(item);
            }
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            //填充报表
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, header, dataSource);

            JasperViewer.viewReport(jasperPrint);

        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
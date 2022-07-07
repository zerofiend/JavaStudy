package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class mainTest {
    public static void main(String[] args) {
        try {
            //  创建读取对象
            SAXReader reader = new SAXReader();
            //  指定解析的xml源
            Document document = reader.read(new File("src/com/xml/stus.xml"));
            //  得到根元素root
            Element rootElement = document.getRootElement();
//            System.out.println(rootElement.getStringValue());
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                System.out.println(element.element("name").getStringValue() + "\t" + element.element("age").getStringValue());
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XpathTest {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("src/com/xml/stus.xml"));
            Element rootElement = document.getRootElement();
            //  Xpath
            List<Element> list = rootElement.selectNodes("//name");
            for (Element element : list) {
                System.out.println(element.getStringValue());
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}

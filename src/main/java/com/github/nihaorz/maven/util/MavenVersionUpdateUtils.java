package com.github.nihaorz.maven.util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Maven版本号更新工具类
 *
 * @author Nihaorz
 */
public class MavenVersionUpdateUtils {

    private static final Logger logger = Logger.getLogger(MavenVersionUpdateUtils.class);

    /**
     * 默认的文件编码
     */
    private static final String defaultCharset = "UTF-8";

    /**
     * 更新parent中的version
     *
     * @param pomPath pom文件路径
     * @param version 版本号
     */
    public static boolean updateParentVersion(String pomPath, String version) {
        return updateParentVersion(pomPath, version, defaultCharset);
    }

    /**
     * 更新parent中的version
     *
     * @param pomPath  pom文件路径
     * @param version  版本号
     * @param encoding 编码
     * @return
     */
    public static boolean updateParentVersion(String pomPath, String version, String encoding) {
        boolean result = false;
        Document document;
        try {
            document = readXml(pomPath, encoding);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return result;
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
            return result;
        }
        Element parentEle = document.getRootElement().element("parent");
        if (parentEle == null) {
            logger.info(pomPath + "文件中没有parent节点");
        } else {
            Element versionEle = parentEle.element("version");
            versionEle.setText(version);
            try {
                result = writerPomXml(pomPath, document);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                return result;
            }
        }
        return result;
    }

    /**
     * 更新version
     *
     * @param pomPath
     * @param version
     * @return
     */
    public static boolean updateVersion(String pomPath, String version) {
        return updateVersion(pomPath, version, defaultCharset);
    }

    /**
     * 更新version
     *
     * @param pomPath pom文件路径
     * @param version 版本号
     */
    public static boolean updateVersion(String pomPath, String version, String encoding) {
        boolean result = false;
        Document document;
        try {
            document = readXml(pomPath, encoding);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return result;
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
            return result;
        }
        Element versionEle = document.getRootElement().element("version");
        if (versionEle == null) {
            logger.info(pomPath + "文件中没有version节点");
        } else {
            versionEle.setText(version);
            try {
                result = writerPomXml(pomPath, document);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                return result;
            }
        }
        return result;
    }

    /**
     * 读取pom文件
     *
     * @param xmlPath
     * @param encoding
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    private static Document readXml(String xmlPath, String encoding) throws IOException, DocumentException {
        File file = new File(xmlPath);
        String xml = FileUtils.readFileToString(file, encoding);
        Document document = DocumentHelper.parseText(xml);
        return document;
    }

    /**
     * 写入新的pom文件
     *
     * @param pomPath  pom文件路径
     * @param document xml文档
     */
    private static boolean writerPomXml(String pomPath, Document document) throws IOException {
        OutputStream os = new FileOutputStream(new File(pomPath));
        XMLWriter xmlWriter = new XMLWriter(os);
        xmlWriter.write(document);
        xmlWriter.close();
        os.close();
        return true;
    }

}

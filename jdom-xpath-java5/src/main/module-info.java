module org.jdom.xpath.java5 {
    requires org.jdom;
    requires org.jdom.to.dom;
    requires java.xml;

    exports org.jdom.contrib.xpath.java;

    provides org.jdom.xpath.XPathFactory with org.jdom.contrib.xpath.java.JavaXPathFactory;
}
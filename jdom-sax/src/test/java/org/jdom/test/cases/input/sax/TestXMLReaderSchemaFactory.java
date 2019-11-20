package org.jdom.test.cases.input.sax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.input.sax.XMLReaderSchemaFactory;
import org.jdom.test.util.FidoFetch;
import org.jdom.test.util.UnitTestUtil;

@SuppressWarnings("javadoc")
public class TestXMLReaderSchemaFactory {

	//org.apache.xerces.jaxp.SAXParserFactoryImpl
	
	@Test
	public void testSchemaXMLReaderFactory() throws SAXException, JDOMException {
		SchemaFactory schemafac = 
				SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemafac.newSchema(FidoFetch.getFido().getURL("/xsdcomplex/SAXTestComplexMain.xsd"));
		XMLReaderSchemaFactory readerfac = new XMLReaderSchemaFactory(schema);
		assertTrue(readerfac.isValidating());
		assertNotNull(readerfac.createXMLReader());
	}

	@Test
	public void testSchemaXMLReaderFactoryXerces() throws SAXException, JDOMException {
		SchemaFactory schemafac = 
				SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemafac.newSchema(FidoFetch.getFido().getURL("/xsdcomplex/SAXTestComplexMain.xsd"));
		XMLReaderSchemaFactory readerfac = new XMLReaderSchemaFactory(
				"org.apache.xerces.jaxp.SAXParserFactoryImpl", null, schema);
		assertTrue(readerfac.isValidating());
		assertNotNull(readerfac.createXMLReader());
	}

	@Test
	public void testSchemaXMLReaderFactoryNull() {
		try {
			new XMLReaderSchemaFactory(null);
			UnitTestUtil.failNoException(NullPointerException.class);
		} catch (Exception e) {
			UnitTestUtil.checkException(NullPointerException.class, e);
		}
	}

	@Test
	public void testSchemaXMLReaderFactoryNullFactory() {
		try {
			new XMLReaderSchemaFactory(null, null, null);
			UnitTestUtil.failNoException(FactoryConfigurationError.class);
		} catch (Throwable e) {
			UnitTestUtil.checkException(FactoryConfigurationError.class, e);
		}
	}

	@Test
	public void testParseValidateWorks() throws JDOMException, IOException, SAXException {
		SchemaFactory schemafac = 
				SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemafac.newSchema(FidoFetch.getFido().getURL("/xsdcomplex/SAXTestComplexMain.xsd"));
		XMLReaderSchemaFactory readerfac = new XMLReaderSchemaFactory(schema);
		assertTrue(readerfac.isValidating());
		SAXBuilder builder = new SAXBuilder(readerfac);
		Document doc = builder.build(FidoFetch.getFido().getURL("/xsdcomplex/input.xml"));
		assertEquals("test", doc.getRootElement().getName());
		// the whole point of this particular XML input is that it should apply
		// default attribute values.... lets make sure they make it.
		int count = 4;
		for (Element data : doc.getRootElement().getChildren("data", Namespace.getNamespace("http://www.jdom.org/tests/default"))) {
			count--;
			assertEquals("simple", data.getAttributeValue("type", Namespace.getNamespace("http://www.jdom.org/tests/imp")));
		}
		assertTrue("" + count + " left", count == 0);
	}
	
	
}

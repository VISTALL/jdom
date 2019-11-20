package org.jdom.test.cases.input.sax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.input.sax.XMLReaders;
import org.jdom.test.util.FidoFetch;
import org.jdom.test.util.UnitTestUtil;

@SuppressWarnings("javadoc")
public class TestXMLReaderSingletons {

	@Test
	public void testNonValidatingReader() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);
		assertFalse(builder.isValidating());
		Document doc = builder.build(FidoFetch.getFido().getURL("/DOMBuilder/attributes.xml"));
		assertEquals("root", doc.getRootElement().getName());
	}

	@Test
	public void testDTDValidatingReader() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
		assertTrue(builder.isValidating());
		Document doc = builder.build(FidoFetch.getFido().getURL("/DOMBuilder/doctype.xml"));
		assertEquals("root", doc.getRootElement().getName());
	}

	@Test
	public void testDTDValidatingReaderFails() {
		SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
		assertTrue(builder.isValidating());
		try {
			builder.build(FidoFetch.getFido().getURL("/DOMBuilder/attributes.xml"));
			UnitTestUtil.failNoException(JDOMException.class);
		} catch (Exception e) {
			UnitTestUtil.checkException(JDOMException.class, e);
		}
	}

	@Test
	public void testXSDValidatingReader() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
		assertTrue(builder.isValidating());
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

	@Test
	public void testXSDValidatingReaderFails() {
		SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
		assertTrue(builder.isValidating());
		try {
			builder.build(FidoFetch.getFido().getURL("/DOMBuilder/attributes.xml"));
			UnitTestUtil.failNoException(JDOMException.class);
		} catch (Exception e) {
			UnitTestUtil.checkException(JDOMException.class, e);
		}
	}

}

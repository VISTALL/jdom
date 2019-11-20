package org.jdom.test.cases.output;

import javax.xml.stream.XMLStreamException;

import org.jdom.Document;
import org.jdom.input.StAXStreamWriter;
import org.jdom.output.StAXStreamOutputter;

@SuppressWarnings("javadoc")
public class TestStAXOutputter2Writer extends AbstractTestRoundTrip {

	@Override
	Document prepare(Document doc) {
		return doc;
	}

	@Override
	Document roundTrip(final Document doc) {
		final StAXStreamWriter sw = new StAXStreamWriter();
		final StAXStreamOutputter so = new StAXStreamOutputter();
		try {
			so.output(doc, sw);
		} catch (XMLStreamException e) {
			throw new IllegalStateException(e);
		}
		return sw.getDocument();
	}

}

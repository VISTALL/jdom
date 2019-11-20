package org.jdom.test.cases.output;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.StAXStreamBuilder;
import org.jdom.output.StAXStreamReader;

@SuppressWarnings("javadoc")
public class TestStAXReader2Builder extends AbstractTestRoundTrip {

	@Override
	Document prepare(Document doc) {
		return doc;
	}

	@Override
	Document roundTrip(final Document doc) {
		final StAXStreamBuilder sb = new StAXStreamBuilder();
		final StAXStreamReader sasr = new StAXStreamReader();
		try {
			return sb.build(sasr.output(doc));
		} catch (JDOMException e) {
			throw new IllegalStateException(e);
		}
	}

}

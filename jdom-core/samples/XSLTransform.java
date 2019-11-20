

import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.transform.*;

@SuppressWarnings("javadoc")
public class XSLTransform {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: java XSLTransformer [some.xml] [some.xsl]");
      return;
    }

    String docname = args[0];
    String sheetname = args[1];
    SAXBuilder builder = new SAXBuilder();
    Document doc = builder.build(docname);

    XSLTransformer transformer = new XSLTransformer(sheetname);
    Document doc2 = transformer.transform(doc);

    Format f = Format.getPrettyFormat();
    f.setLineSeparator(LineSeparator.DOS);
    XMLOutputter outp = new XMLOutputter(f);
    outp.output(doc2, System.out);
  }
}

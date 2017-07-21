#DOM PARSER
 DOM parser parses the entire XML document and loads it into memory; then models it in a “TREE”   structure for easy traversal or manipulation.


# Here in a more simple words:

DOM -Tree model parser(Object based) (Tree of nodes).

-DOM loads the file into the memory and then parse the file.

-Has memory constraints since it loads the whole XML file before parsing.

-DOM is read and write (can insert or delete the node).

-If the XML content is small then prefer DOM parser.

-Backward and forward search is possible for searching the tags and evaluation of the information inside the tags. So this gives the ease of navigation.

-Slower at run time.


# SAX PARSER
SAX parser is working differently with a DOM parser, it neither load any XML document into memory nor create any object representation of the XML document. Instead, the SAX parser use callback function (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document structure.

SAX Parser is faster and uses less memory than DOM parser.

# SAX callback methods :

* startDocument() and endDocument() – Method called at the start and end of an XML document.
* startElement() and endElement() – Method called at the start and end of a document element.
* characters() – Method called with the text contents in between the start and end tags of an XML document element.


SAX

-Event based parser (Sequence of events).

-SAX parses the file at it reads i.e. Parses node by node.

-No memory constraints as it does not store the XML content in the memory.

-SAX is read only i.e. can’t insert or delete the node.

-Use SAX parser when memory content is large.

-SAX reads the XML file from top to bottom and backward navigation is not possible.

-Faster at run time.


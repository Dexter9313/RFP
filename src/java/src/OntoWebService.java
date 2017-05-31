package rfp;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import org.apache.jena.iri.impl.Main;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.mem.GraphTripleStore;
import org.apache.jena.graph.Triple;
import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.query.ReadWrite;

public class OntoWebService extends Onto {

    String wsdlFileName;

    public OntoWebService(String namespace, String wsdlFileName) {
        super(namespace);
        this.wsdlFileName = wsdlFileName;
    }

    public void convert() {
        try {
            File wsdlFile = new File(wsdlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(wsdlFile);

            doc.getDocumentElement().normalize();

            // First we get the name of the web service
            String wsName = doc.getDocumentElement().getAttribute("name");
            OntClass wsClassName = ontologie.createClass(namespace + "webServiceName");
            ontologie.createIndividual(namespace + wsName, wsClassName);

            System.out.println("Ontologie creation succeed !!!");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}



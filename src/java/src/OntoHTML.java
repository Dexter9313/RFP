package rfp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.metadata.TikaCoreProperties;


//Converts an excel file to ontology

public class OntoHTML extends Onto
{
	String Contributor;
	String Coverage;
	String Creator;
	String Date;
	String Description;
	String Format;
	String Identifier;
	String Language;
	String Modified;
	String Publisher;
	String Relation;
	String Rights;
	String Source;
	String Keywords;
	String Title;
	String Type;
	String FileHTMLInit;

	public OntoHTML(String namespace, String FileHTML)
	{
		super(namespace);

		FileHTMLInit = FileHTML;

		try
		{
			FileInputStream fis = new FileInputStream(FileHTML);
			Metadata metadata = new Metadata();
			HtmlParser htmlParser = new HtmlParser();
			htmlParser.parse(fis, null, metadata, null);
			fis.close();

			String Contributor = metadata.get(TikaCoreProperties.CONTRIBUTOR);
			String Coverage = metadata.get(TikaCoreProperties.COVERAGE);
			String Creator = metadata.get(TikaCoreProperties.CREATOR);
			String Date = metadata.get(TikaCoreProperties.CREATED);
			String Description = metadata.get(TikaCoreProperties.DESCRIPTION);
			String Format = metadata.get(TikaCoreProperties.FORMAT);
			String Identifier = metadata.get(TikaCoreProperties.IDENTIFIER);
			String Language = metadata.get(TikaCoreProperties.LANGUAGE);
			String Modified = metadata.get(TikaCoreProperties.MODIFIED);
			String Publisher = metadata.get(TikaCoreProperties.PUBLISHER);
			String Relation = metadata.get(TikaCoreProperties.RELATION);
			String Rights = metadata.get(TikaCoreProperties.RIGHTS);
			String Source = metadata.get(TikaCoreProperties.SOURCE);
			String Keywords = metadata.get(TikaCoreProperties.KEYWORDS);
			String Title = metadata.get(TikaCoreProperties.TITLE);
			String Type = metadata.get(TikaCoreProperties.TYPE);
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void convert()
	{
		//TODO Do right classes
		CreateNewHTMLClass("Document", "CreatedBy", "Document", "no");
		CreateNewHTMLClass("Auteur", "CreatorOf", "Auteur", "Document");
		// Onto.CreateNewHTMLClass("Document", "ModifiedBy", "Document",
		// "Auteur");
		CreateNewHTMLClass("Title", "TitleOf", "Title", "Document");
		CreateNewHTMLClass("Description", "DescriptionOf", "Description",
						   "Document");
		CreateNewHTMLClass("Subject", "Concern", "Subject", "Document");
		CreateNewHTMLClass("Category", "hasDocument", "Category",
						   "Document");
		CreateNewHTMLClass("Manager", "ManageSubject", "Manager",
						   "Subject");
		CreateNewHTMLClass("Company", "hasasetof", "Company", "Document");
		// Onto.CreateNewHTMLClass("Company", "hasasetof", "Company",
		// "Template");
		CreateNewHTMLClass("Date", "CreationDateOf", "Date", "Document");

		CreatNewHTMLIndiv("Document", FileHTMLInit);
		//TODO instanciate right instances
		/*CreatNewHTMLIndiv("Auteur", DocumentCreator);
		CreatNewHTMLIndiv("Title", Title);
		CreatNewHTMLIndiv("Description", Description);
		CreatNewHTMLIndiv("Subject", Subject);
		CreatNewHTMLIndiv("Category", Category);
		CreatNewHTMLIndiv("Manager", Manager);
		CreatNewHTMLIndiv("Company", Company);*/
	}

	public void CreateNewHTMLClass(String ClassName, String Prop, String Dom,
								   String Ran)
	{
		ontologie.createClass(namespace + ClassName);
		ObjectProperty newProp
			= ontologie.createObjectProperty(namespace + Prop);
		OntClass Domain = ontologie.getOntClass(namespace + Dom);
		// set Domain and Rang
		newProp.setDomain(Domain);

		if(Ran != "no")
		{
			OntClass Rang = ontologie.getOntClass(namespace + Ran);
			newProp.setRange(Rang);
		}
	}

	public void CreatNewHTMLIndiv(String ClassName, String Indiv)
	{
		OntClass Cname = ontologie.getOntClass(namespace + ClassName);
		ontologie.createIndividual(namespace + Indiv, Cname);
	}

}

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
import org.xml.sax.helpers.DefaultHandler;
import org.apache.tika.parser.ParseContext;


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
			htmlParser.parse(fis, new DefaultHandler(), metadata, new ParseContext());
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
		CreateNewClass("Document", "CreatedBy", "Document", "no");
		CreateNewClass("Coverage", "CoveredBy", "Coverage", "Document");
		CreateNewClass("Author", "CreatorOf", "Author", "Document");
		CreateNewClass("Date", "CreationDateOf", "Date", "Document");
		CreateNewClass("Description", "DescriptionOf", "Description", "Document");
		CreateNewClass("Format", "FormatOf", "Format",
					   "Document");
		CreateNewClass("Identifier", "IdentifierOf", "Identifier",
					   "Document");
		CreateNewClass("Language", "LanguageOf", "Language",
					   "Document");
		CreateNewClass("ModifiedDate", "ModifiedDateOf", "ModifiedDate",
					   "Document");
		CreateNewClass("Publisher", "PublisherOf", "Publisher",
					   "Document");
		CreateNewClass("Relation", "RelationOf", "Relation",
					   "Document");
		CreateNewClass("Rights", "RightsOf", "Rights",
					   "Document");
		CreateNewClass("Source", "SourceOf", "Source",
					   "Document");
		CreateNewClass("Keywords", "KeywordsOf", "Keywords",
					   "Document");
		CreateNewClass("Title", "TitleOf", "Title",
					   "Document");
		CreateNewClass("Type", "TypeOf", "Type",
					   "Document");

		CreateNewIndiv("Document", FileHTMLInit);
		CreateNewIndiv("Coverage", Coverage);
		CreateNewIndiv("Author", Creator);
		CreateNewIndiv("Date", Date);
		CreateNewIndiv("Description", Description);
		CreateNewIndiv("Format", Format);
		CreateNewIndiv("Identifier", Identifier);
		CreateNewIndiv("Language", Language);
		CreateNewIndiv("ModifiedDate", Modified);
		CreateNewIndiv("Publisher", Publisher);
		CreateNewIndiv("Relation", Relation);
		CreateNewIndiv("Rights", Rights);
		CreateNewIndiv("Source", Source);
		CreateNewIndiv("Keywords", Keywords);
		CreateNewIndiv("Title", Title);
		CreateNewIndiv("Type", Type);
	}

}

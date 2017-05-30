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

			Contributor = metadata.get(metadata.CONTRIBUTOR);
			Coverage = metadata.get(metadata.COVERAGE);
			Creator = metadata.get("author");
			Date = metadata.get(metadata.DATE);
			Description = metadata.get(metadata.DESCRIPTION);
			Format = metadata.get(metadata.FORMAT);
			Identifier = metadata.get(metadata.IDENTIFIER);
			Language = metadata.get(metadata.LANGUAGE);
			Modified = metadata.get(metadata.MODIFIED);
			Publisher = metadata.get(metadata.PUBLISHER);
			Relation = metadata.get(metadata.RELATION);
			Rights = metadata.get(metadata.RIGHTS);
			Source = metadata.get(metadata.SOURCE);
			Keywords = metadata.get("keywords");
			Title = metadata.get(metadata.TITLE);
			Type = metadata.get(metadata.TYPE);

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

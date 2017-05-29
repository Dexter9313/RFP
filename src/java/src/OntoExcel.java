package rfp;
import rfp.utils.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


//Converts an excel file to ontology

public class OntoExcel extends Onto
{
	String DocumentCreator;
	String Creationdate;
	String LastModif;
	String LastModifC;
	String Description;
	String Keywords;
	String Title;
	String Subject;
	String Category;
	String Company;
	String Template;
	String Manager;
	String FileExcelInit;

	public OntoExcel(String namespace, String FileExcel)
	{
		super(namespace);

		FileExcelInit = FileExcel;

		try
		{
			ExcelFileExtractor ExcelFile
				= new ExcelFileExtractor(FileExcelInit);
			ExcelFile.MetadataExtractor();
			DocumentCreator = ExcelFile.DocumentCreator;
			Creationdate    = ExcelFile.Creationdate;
			LastModif       = ExcelFile.LastModif;
			LastModifC      = ExcelFile.LastModifC;
			Description     = ExcelFile.Description;
			Keywords        = ExcelFile.Keywords;
			Title           = ExcelFile.Title;
			Subject         = ExcelFile.Subject;
			Category        = ExcelFile.Company;
			Company         = ExcelFile.Company;
			Template        = ExcelFile.Template;
			Manager         = ExcelFile.Manager;
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void convert()
	{
		CreateNewClass("Document", "CreatedBy", "Document", "no");
		CreateNewClass("Auteur", "CreatorOf", "Auteur", "Document");
		// Onto.CreateNewExceClass("Document", "ModifiedBy", "Document",
		// "Auteur");
		CreateNewClass("Title", "TitleOf", "Title", "Document");
		CreateNewClass("Description", "DescriptionOf", "Description",
					   "Document");
		CreateNewClass("Subject", "Concern", "Subject", "Document");
		CreateNewClass("Category", "hasDocument", "Category",
					   "Document");
		CreateNewClass("Manager", "ManageSubject", "Manager",
					   "Subject");
		CreateNewClass("Company", "hasasetof", "Company", "Document");
		// Onto.CreateNewExceClass("Company", "hasasetof", "Company",
		// "Template");
		CreateNewClass("Date", "CreationDateOf", "Date", "Document");

		CreatNewIndiv("Document", FileExcelInit);
		CreatNewIndiv("Auteur", DocumentCreator);
		CreatNewIndiv("Title", Title);
		CreatNewIndiv("Description", Description);
		CreatNewIndiv("Subject", Subject);
		CreatNewIndiv("Category", Category);
		CreatNewIndiv("Manager", Manager);
		CreatNewIndiv("Company", Company);
	}

}

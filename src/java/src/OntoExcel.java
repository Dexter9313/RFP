package rfp;
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
			CreateNewExceClass("Document", "CreatedBy", "Document", "no");
			CreateNewExceClass("Auteur", "CreatorOf", "Auteur", "Document");
			// Onto.CreateNewExceClass("Document", "ModifiedBy", "Document",
			// "Auteur");
			CreateNewExceClass("Title", "TitleOf", "Title", "Document");
			CreateNewExceClass("Description", "DescriptionOf", "Description",
							   "Document");
			CreateNewExceClass("Subject", "Concern", "Subject", "Document");
			CreateNewExceClass("Category", "hasDocument", "Category",
							   "Document");
			CreateNewExceClass("Manager", "ManageSubject", "Manager",
							   "Subject");
			CreateNewExceClass("Company", "hasasetof", "Company", "Document");
			// Onto.CreateNewExceClass("Company", "hasasetof", "Company",
			// "Template");
			CreateNewExceClass("Date", "CreationDateOf", "Date", "Document");

			CreatNewExcelIndiv("Document", FileExcelInit);
			CreatNewExcelIndiv("Auteur", DocumentCreator);
			CreatNewExcelIndiv("Title", Title);
			CreatNewExcelIndiv("Description", Description);
			CreatNewExcelIndiv("Subject", Subject);
			CreatNewExcelIndiv("Category", Category);
			CreatNewExcelIndiv("Manager", Manager);
			CreatNewExcelIndiv("Company", Company);
		}

		public void CreateNewExceClass(String ClassName, String Prop, String Dom,
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

		public void CreatNewExcelIndiv(String ClassName, String Indiv)
		{
			OntClass Cname = ontologie.getOntClass(namespace + ClassName);
			ontologie.createIndividual(namespace + Indiv, Cname);
		}

}

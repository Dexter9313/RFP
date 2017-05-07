package ontotest;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelToOnto
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

	public ExcelToOnto(String FileExcel)
	{
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

	public void ExcelOntoConv(String onto, String FileName)
	{
		OntoExcel Onto = new OntoExcel(onto);
		Onto.CreateNewExceClass("Document", "CreatedBy", "Document", "no");
		Onto.CreateNewExceClass("Auteur", "CreatorOf", "Auteur", "Document");
		// Onto.CreateNewExceClass("Document", "ModifiedBy", "Document",
		// "Auteur");
		Onto.CreateNewExceClass("Title", "TitleOf", "Title", "Document");
		Onto.CreateNewExceClass("Description", "DescriptionOf", "Description",
		                        "Document");
		Onto.CreateNewExceClass("Subject", "Concern", "Subject", "Document");
		Onto.CreateNewExceClass("Category", "hasDocument", "Category",
		                        "Document");
		Onto.CreateNewExceClass("Manager", "ManageSubject", "Manager",
		                        "Subject");
		Onto.CreateNewExceClass("Company", "hasasetof", "Company", "Document");
		// Onto.CreateNewExceClass("Company", "hasasetof", "Company",
		// "Template");
		Onto.CreateNewExceClass("Date", "CreationDateOf", "Date", "Document");

		Onto.CreatNewExcelIndiv("Document", FileExcelInit);
		Onto.CreatNewExcelIndiv("Auteur", DocumentCreator);
		Onto.CreatNewExcelIndiv("Title", Title);
		Onto.CreatNewExcelIndiv("Description", Description);
		Onto.CreatNewExcelIndiv("Subject", Subject);
		Onto.CreatNewExcelIndiv("Category", Category);
		Onto.CreatNewExcelIndiv("Manager", Manager);
		Onto.CreatNewExcelIndiv("Company", Company);

		Onto.OntoExcellFile(FileName);
	}

	public static void main(String[] args)
	{
		ExcelToOnto Testfile = new ExcelToOnto(args[0]);
		Testfile.ExcelOntoConv("http://www.ontologie.fr/monOntologie#",
		                       args[0] + ".rdf");
	}
}

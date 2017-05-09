package rfp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceToOnto
{
	public static void main(String[] args)
	{
		//TODO : decide which is resource type here
		OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",args[0]);
		onto.ExcelOntoConv(args[0] + ".rdf");
	}
}

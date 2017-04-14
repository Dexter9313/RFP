package ontotest;
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

public class OntoExcel {
	OntModel ontologie;
	String namespace;
	
	public OntoExcel (String NameSpace)
	{ontologie = ModelFactory.createOntologyModel();	
	namespace = NameSpace;
	ontologie.createOntology (namespace);}
	
	
	
	public void CreateNewExceClass(String ClassName, String Prop,String Dom, String Ran)
	{ ontologie.createClass (namespace + ClassName);
	ObjectProperty newProp = ontologie.createObjectProperty (namespace + Prop);	
	OntClass Domain = ontologie.getOntClass(namespace + Dom);
	// set Domain and Rang
	newProp.setDomain (Domain);
	if (Ran!="no")
			{OntClass Rang = ontologie.getOntClass(namespace + Ran);
			newProp.setRange(Rang);
			} 
	}
	public void CreatNewExcelIndiv (String ClassName, String Indiv)
	{   OntClass Cname = ontologie.getOntClass(namespace + ClassName);
		ontologie.createIndividual(namespace+Indiv, Cname);}

	public void OntoExcellFile(String FileName)	
	{FileOutputStream fichierSortie = null;

	try {
		fichierSortie = new FileOutputStream (new File (FileName));
	}
	catch (FileNotFoundException ex) {
		Logger.getLogger (Main.class.getName ()).log (Level.SEVERE, null, ex);
	}

	ontologie.write (fichierSortie);
try {
fichierSortie.close();
} catch (IOException e) {
e.printStackTrace();
}

	}
	public static void main(String[] args) {
	
	
}
}
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

public abstract class Onto
{
	OntModel ontologie;
	String namespace;

	public Onto(String namespace)
	{
		ontologie = ModelFactory.createOntologyModel();
		ontologie.createOntology(namespace);
		this.namespace = namespace;
	}

	//actual method which does the convertion rsc->onto
	protected abstract void convert();

	protected void CreateNewClass(String ClassName, String Prop, String Dom,
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

	protected void CreatNewIndiv(String ClassName, String Indiv)
	{
		OntClass Cname = ontologie.getOntClass(namespace + ClassName);
		ontologie.createIndividual(namespace + Indiv, Cname);
	}

	//left out comments are legacy ways of doing, soon to be deleted
	public void persist(String fileName)
	{
		/*FileOutputStream fichierSortie = null;

		try
		{
			fichierSortie = new FileOutputStream(new File(fileName));
		}
		catch(FileNotFoundException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}*/


		//ontologie.write(fichierSortie, "N3");
		//GraphTripleStore graph = new GraphTripleStore(null);
		Dataset dataset = TDBFactory.createDataset("uploads/dataset");
		dataset.begin(ReadWrite.WRITE);
		dataset.addNamedModel("foo", ontologie);
		dataset.commit();
		dataset.end();
		/*try
		{
			for(Statement s : ontologie.listStatements(null, null, (RDFNode)null).toList())
			{
				fichierSortie.write(s.toString().getBytes());
				fichierSortie.write("\n".getBytes());

				//graph.add(new Triple(s.getObject().asNode(), s.getPredicate().asNode(), s.getResource().asNode()));
			}
			fichierSortie.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}*/

	}

}

package rfp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceToOnto
{
		/* args[0] = resource type
		 * args[1] = resource path */
		public static void main(String[] args)
		{
			if(args[0] == "--excel")
			{
				OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",
											   args[1]);
				onto.persist(args[1] + ".rdf");
			}
			else if(args[0] == "--db")
			{
				/* TODO : implement OntoDB */
				String foo = args[0];
			}
			else if(args[0] == "--html")
			{
				/* TODO : implement OntoHTML */
				String foo = args[0];
			}
			else if(args[0] == "--service")
			{
				/* TODO : implement OntoService */
				String foo = args[0];
			}
		}
}

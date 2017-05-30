<<<<<<< HEAD
package rfp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;

public class ResourceToOnto
{
    /* args[0] = resource type
     * args[1] = resource path */
    public static void main(String[] args)
    {
        System.out.println(args[0]);
        if(args[0].equals("--excel"))
        {
            OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",
                                           args[1]);
            onto.convert();
            onto.persist(args[1] + ".rdf");
        }
        else if(args[0].equals("--db"))
        {
            try {
                Scanner scanner = new Scanner(new File(args[1]));
                String url = "jdbc:mysql://" + scanner.nextLine();
                String userName = scanner.nextLine();
                String password = scanner.nextLine();
                scanner.close();

                OntoDB onto = new OntoDB("http://www.ontologie.fr/monOntologie#",
                                         url,
                                         userName,
                                         password);
                onto.convert();
                onto.persist(args[1] + ".rdf");
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else if(args[0].equals("--html"))
        {
            /* TODO : implement OntoHTML */
            String foo = args[0];
        }
        else if(args[0].equals("--service"))
        {
            OntoWebService onto = new OntoWebService("http://www.ontologie.fr/monOntologie#",
                args[1]);
            onto.convert();
            onto.pesist(args[1] + ".rdf");
            String foo = args[0];
        }
    }
}








||||||| merged common ancestors
package rfp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;

public class ResourceToOnto
{
    /* args[0] = resource type
     * args[1] = resource path */
    public static void main(String[] args)
    {
        System.out.println(args[0]);
        if(args[0].equals("--excel"))
        {
            OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",
                                           args[1]);
            onto.convert();
            onto.persist(args[1] + ".rdf");
        }
        else if(args[0].equals("--db"))
        {
            try {
                Scanner scanner = new Scanner(new File(args[1]));
                String url = "jdbc:mysql://" + scanner.nextLine();
                String userName = scanner.nextLine();
                String password = scanner.nextLine();
                scanner.close();

                OntoDB onto = new OntoDB("http://www.ontologie.fr/monOntologie#",
                                         url,
                                         userName,
                                         password);
                onto.convert();
                onto.persist(args[1] + ".rdf");
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else if(args[0].equals("--html"))
        {
            /* TODO : implement OntoHTML */
            String foo = args[0];
        }
        else if(args[0].equals("--service"))
        {
            /* TODO : implement OntoService */
            String foo = args[0];
        }
    }
}








=======
package rfp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;

public class ResourceToOnto
{
	/* args[0] = resource type
	 * args[1] = resource path */
	public static void main(String[] args)
	{
		if(args[0].equals("--excel"))
		{
			OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",
										   args[1]);
			onto.convert();
			onto.persist(args[1] + ".owl");
		}
		else if(args[0].equals("--db"))
		{
			try
			{
				Scanner scanner = new Scanner(new File(args[1]));
				String url = "jdbc:mysql://" + scanner.nextLine();
				String userName = scanner.nextLine();
				String password = scanner.nextLine();
				scanner.close();

				OntoDB onto = new OntoDB("http://www.ontologie.fr/monOntologie#",
										 url,
										 userName,
										 password);
				onto.convert();
				onto.persist(args[1] + ".owl");
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}

		}
		else if(args[0].equals("--html"))
		{
			OntoHTML onto = new OntoHTML("http://www.ontologie.fr/monOntologie#",
										 args[1]);
			onto.convert();
			onto.persist(args[1] + ".owl");
		}
		else if(args[0].equals("--service"))
		{
			/* TODO : implement OntoService */
			String foo = args[0];
		}
		else
		{
			System.out.println("USAGE :\nResourceToOnto TYPE FILE_PATH\n\tTYPE : --excel|--db|--html|--service");
		}
	}
}








>>>>>>> e1d73b0caf13f48151dfbc95f3b09fb3891269fc

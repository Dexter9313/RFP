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
        if(args[0] == "--excel")
        {
            OntoExcel onto = new OntoExcel("http://www.ontologie.fr/monOntologie#",
                                           args[1]);
            onto.persist(args[1] + ".rdf");
        }
        else if(args[0] == "--db")
        {
            try {
                Scanner scanner = new Scanner(new File(args[1]));
                String url = scanner.nextLine();
                String userName = scanner.nextLine();
                String password = scanner.nextLine();
                scanner.close();
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }

            OntoDB onto = new OntoDB("http://www.ontologie.fr/monOntologie#",
                                     url,
                                     userName,
                                     password);
            onto.persist(args[1] + ".rdf");
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







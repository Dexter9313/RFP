package ontotest;
import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.POIXMLProperties;
public class ExcelFileExtractor
{
	FileInputStream input_document = null;
	String DocumentCreator;
	String Creationdate ;
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
	private XSSFWorkbook readMetadata;
	private static XSSFWorkbook workbook;
	
	public ExcelFileExtractor (String args) throws FileNotFoundException
	{
		 input_document = new FileInputStream(new File(args));
	}
	
  public  void MetadataExtractor ()
     throws IOException
  {
    readMetadata = new XSSFWorkbook(input_document);
    POIXMLProperties props = readMetadata.getProperties();
    POIXMLProperties.CoreProperties coreProp=props.getCoreProperties();
    /* Read and print core properties as SOP */
    
    DocumentCreator =coreProp.getCreator(); 
    Creationdate=coreProp.getCreated().toString();
    LastModif=coreProp.getModified().toString();
    LastModifC=coreProp.getLastModifiedByUser();
    Description=coreProp.getDescription();
    Keywords=coreProp.getKeywords();
    Title=coreProp.getTitle();
    Subject=coreProp.getSubject();
    Category=coreProp.getCategory(); 
    /* Read and print extended properties */
   POIXMLProperties.ExtendedProperties extProp=props.getExtendedProperties();
  Company=extProp.getUnderlyingProperties().getCompany();
  Template=extProp.getUnderlyingProperties().getTemplate();
  Manager=extProp.getUnderlyingProperties().getManager();    
        /* Finally, we can retrieve some custom Properies 
   POIXMLProperties.CustomProperties custProp = props.getCustomProperties();
    List<CTProperty> my1=custProp.getUnderlyingProperties().getPropertyList();
    System.out.println("Size :" + my1.size());
    for (int i = 0; i < my1.size(); i++) {
           CTProperty pItem = my1.get(i);
           System.out.println(""+pItem.getPid());
           System.out.println(""+pItem.getFmtid());
           System.out.println(""+pItem.getName());
           System.out.println(""+pItem.getLpwstr());
          
           */
  }

  
  public static void CellsRowsExtractor (String args) throws IOException
  {
	  FileInputStream fis = new FileInputStream (new File(args));
		   
		      workbook = new XSSFWorkbook(fis);
		      XSSFSheet spreadsheet = workbook.getSheetAt(0);

		      int lastcell=spreadsheet.getRow(0).getLastCellNum();
		      int lastRow=spreadsheet.getLastRowNum();
		      //Non empty Last cell Number or index return

		      for(int i=0;i<=lastcell;i++)
		      {
		          try
		          {
		              System.out.println(spreadsheet.getRow(0).getCell(i)
		            		    .getRichStringCellValue().toString());
		          }catch(Exception e)
		          {};
		      }
		      for(int i=0;i<=lastRow;i++)
		      {
		          try
		          {
		              System.out.println(spreadsheet.getRow(i).getCell(1)
		            		    .getRichStringCellValue().toString());
		          }catch(Exception e)
		          {};
		      }
		      fis.close();
			
  
  }
  
  public static void main (String [] arg){
	  
	
	  try {
		  ExcelFileExtractor newtruc= new ExcelFileExtractor ("Ressources/Diagnostics.xlsx");
	newtruc.MetadataExtractor ();
	System.out.println(newtruc.Keywords);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
}
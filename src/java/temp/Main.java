import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

class Main
{
		public static void main(String args[])
        {
			try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

				String sCurrentLine;

				PrintWriter writer = new PrintWriter(args[0]+".txt", "UTF-8");

				while ((sCurrentLine = br.readLine()) != null) {
					writer.println(sCurrentLine);
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

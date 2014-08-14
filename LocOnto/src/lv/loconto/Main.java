package lv.loconto;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.tdb.TDBFactory;

public class Main {

	public static void main(String[] args) {
		
		//Make a TDB-backed dataset
		String directory = "BD/Dataset1" ;
		Dataset dataset = TDBFactory.createDataset(directory) ;
		
		Model model = ModelFactory.createDefaultModel();
		
		dataset.begin(ReadWrite.WRITE);
		dataset.addNamedModel("Test", model);
		
		/*dataset.begin(ReadWrite.READ) ;
		// Get model inside the transaction
		Model model = dataset.getDefaultModel() ;
		dataset.end() ;
		dataset.begin(ReadWrite.WRITE) ;
		model = dataset.getDefaultModel() ;*/
		dataset.end() ;

	}

}

package lv.loconto;

import lv.loconto.tdb.ModelDAO;
import lv.loconto.tdb.ModelDAOImpl;

import com.hp.hpl.jena.ontology.OntModel;

public class Main {

	public static void main(String[] args) {
		
		//OntoCreator.Create();
		ModelDAO dao = new ModelDAOImpl();
		OntModel ontMod = dao.getDefaultModel();
		
		ontMod.writeAll(System.out, "RDF/XML");
	}

}

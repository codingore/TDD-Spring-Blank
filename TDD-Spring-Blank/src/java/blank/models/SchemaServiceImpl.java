package blank.models;

import org.springframework.stereotype.Service;

@Service
public class SchemaServiceImpl implements SchemaService {

	private SchemaDAO schemaDAO;
	
	public void setSchemaDAO(SchemaDAO schemaDAO) {
		this.schemaDAO = schemaDAO;
	}
	
	@Override
	public void executeSqlScript(String filename) {
		this.schemaDAO.executeSqlScript(filename);
	}

}

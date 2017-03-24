package fr.iutinfo.skeleton.planning;
import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.api.BDDFactory;
import fr.iutinfo.skeleton.common.dto.ParentDto;
import fr.iutinfo.skeleton.common.dto.SalarieDto;

@Path("/salarie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalarieRessource {
	final static Logger logger = LoggerFactory.getLogger(SalarieRessource.class);
	private static SalarieDao dao = getDbi().open(SalarieDao.class);

	public SalarieRessource() throws Exception {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1980);
		c.set(Calendar.MONTH, 4);
		c.set(Calendar.DATE, 21);
		if (!BDDFactory.tableExist("salaries")) {
			logger.debug("Create table salaries");
			dao.createParentTable();
			dao.insert(new Salarie("toto","truc","français",c,"5 rue Moulinelle", "1300","126489a9745e56"));
		}
	}

	@POST
	public SalarieDto createSalarie(SalarieDto dto) throws Exception {
		Salarie salarie = new Salarie();
		salarie.initFromDto(dto);
		String nom = dao.insert(salarie);
		dto.setNom(nom);
		return dto;
	}

	@GET
	@Path("/{id}")
	public SalarieDto getSalarie(@PathParam("id") int id) throws Exception {
		
		Salarie salarie = dao.findById(id);
		if (salarie == null) {
			throw new WebApplicationException(404);
		}
		return salarie.convertToDto();
	}

	@GET
	public List<SalarieDto> getAllSalaries(@QueryParam("q") int id) throws Exception{

		List<Salarie> salarie;
		if (id == 0) {
			salarie = dao.all();
		} else {
			logger.debug("Search salaries with query: " + id);
			salarie = dao.search(id);
		}
		return salarie.stream().map(Salarie::convertToDto).collect(Collectors.toList());
	}

	@DELETE
	@Path("/{id}")
	public void deleteSalarie(@PathParam("id") int id) {
		dao.delete(id);
	}

}

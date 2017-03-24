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
import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;
import fr.iutinfo.skeleton.common.dto.CreneauDto;
import fr.iutinfo.skeleton.common.dto.EnfantDto;

@Path("/enfant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnfantRessource {
	final static Logger logger = LoggerFactory.getLogger(EnfantRessource.class);
	private static EnfantDao dao = getDbi().open(EnfantDao.class);

	public EnfantRessource() throws Exception {
		String c = "16/03/1997";
		if (!tableExist("enfants")) {
			logger.debug("Create table enfants");
			dao.createEnfantTable();
			dao.insert(new Enfant("Timothe","ruccart",c,"5 rue de la paix", "Lundi matin, Jeudi après-midi"));
		}
	}

	@POST
	public EnfantDto createEnfant(EnfantDto dto) throws Exception {
		Enfant enfant = new Enfant();
		enfant.initFromDto(dto);
		String nom = dao.insert(enfant);
		dto.setNom(nom);
		return dto;
	}

	@GET
	@Path("/{id}")
	public EnfantDto getEnfant(@PathParam("id") int id) throws Exception {
		
		Enfant enfant = dao.findById(id);
		if (enfant == null) {
			throw new WebApplicationException(404);
		}
		return enfant.convertToDto();
	}

	@GET
	public List<EnfantDto> getAllUsers(@QueryParam("q") int id) throws Exception{

		List<Enfant> enfant;
		if (id == 0) {
			enfant = dao.all();
		} else {
			logger.debug("Search users with query: " + id);
			enfant = dao.search(id);
		}
		return enfant.stream().map(Enfant::convertToDto).collect(Collectors.toList());
	}

	@DELETE
	@Path("/{id}")
	public void deleteEnfant(@PathParam("id") int id) {
		dao.delete(id);
	}

}

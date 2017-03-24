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
import fr.iutinfo.skeleton.common.dto.CreneauDto;

@Path("/creneaux")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreneauResource {
	final static Logger logger = LoggerFactory.getLogger(CreneauResource.class);
	private static CreneauDao dao = getDbi().open(CreneauDao.class);

	public CreneauResource() throws Exception {
		String c ="10/03/1888";
		if (!BDDFactory.tableExist("creneaux")) {
			logger.debug("Create table creneaux");
			dao.createCreneauTable();
			dao.insert(new Creneau("previsionnel",c,"800", "1200", "Anais, théo")); //date, heureDebut, heureFin, listEnfant
		}
	}

	@POST
	public CreneauDto createCreneau(CreneauDto dto) throws Exception {
		Creneau creneau = new Creneau();
		creneau.initFromDto(dto);
		String heureDebut = dao.insert(creneau);
		dto.setHeureDebut(heureDebut);
		return dto;
	}

	@GET
	@Path("/{id}")
	public CreneauDto getCreneau(@PathParam("id") int id) throws Exception {
		
		Creneau creneau = dao.findById(id);
		if (creneau == null) {
			throw new WebApplicationException(404);
		}
		return creneau.convertToDto();
	}

	@GET
	public List<CreneauDto> getAllCreneaux(@QueryParam("q") int id) throws Exception{

		List<Creneau> creneau;
		if (id == 0) {
			creneau = dao.all();
		} else {
			logger.debug("Search users with query: " + id);
			creneau = dao.search(id);
		}
		return creneau.stream().map(Creneau::convertToDto).collect(Collectors.toList());
	}

	@DELETE
	@Path("/{id}")
	public void deleteCreneau(@PathParam("id") int id) {
		dao.delete(id);
	}

}

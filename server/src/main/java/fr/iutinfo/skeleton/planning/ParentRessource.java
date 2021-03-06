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
import fr.iutinfo.skeleton.common.dto.EnfantDto;
import fr.iutinfo.skeleton.common.dto.ParentDto;

@Path("/parent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParentRessource {
	final static Logger logger = LoggerFactory.getLogger(ParentRessource.class);
	private static ParentDao dao = getDbi().open(ParentDao.class);

	public ParentRessource() throws Exception {
		if (!tableExist("parents")) {
			logger.debug("Create table parents");
			dao.createParentTable();
			
		}
	}

	@POST
	public ParentDto createParent(ParentDto dto) throws Exception {
		Parent parent = new Parent();
		parent.initFromDto(dto);
		String nom = dao.insert(parent);
		return dto;
	}

	@GET
	@Path("/{id}")
	public ParentDto getParent(@PathParam("id") int id) throws Exception {
		
		Parent parent = dao.findById(id);
		if (parent == null) {
			throw new WebApplicationException(404);
		}
		return parent.convertToDto();
	}

	@GET
	public List<ParentDto> getAllParents(@QueryParam("q") int id) throws Exception{

		List<Parent> parent;
		if (id == 0) {
			parent = dao.all();
		} else {
			logger.debug("Search users with query: " + id);
			parent = dao.search(id);
		}
		return parent.stream().map(Parent::convertToDto).collect(Collectors.toList());
	}
    @POST
    @Path("/{id}")
    public void updateParent(@PathParam("id") int id, ParentDto parent)throws Exception{

	  dao.update(parent);
	

    }
    

	@DELETE
	@Path("/{id}")
	public void deleteParent(@PathParam("id") int id) {
		dao.delete(id);
	}

}

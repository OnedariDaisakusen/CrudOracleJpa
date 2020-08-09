package com.rest.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.core.entidad.Usuario;

@Repository
public class UsuarioRepository {

	private EntityManager entityManager;

    @Autowired
    public UsuarioRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Usuario> lista(int id){
    	List<Usuario> data = new ArrayList<Usuario>();
    	
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("SINPAD.BAH_PKG_ADMINISTRACION.USP_SEL_LISTAR_USUARIO");
        
        storedProcedureQuery.registerStoredProcedureParameter("PI_IDE_DDI", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("PO_CURSOR_USUARIO", Usuario.class, ParameterMode.REF_CURSOR);
        storedProcedureQuery.registerStoredProcedureParameter("PO_CODIGO_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("PO_MENSAJE_RESPUESTA", String.class, ParameterMode.OUT);
        
        storedProcedureQuery.setParameter("PI_IDE_DDI", id);

        storedProcedureQuery.execute();
        
        String respuesta = (String) storedProcedureQuery.getOutputParameterValue("PO_MENSAJE_RESPUESTA");
        
        Iterable<Usuario>  results = storedProcedureQuery.getResultList();
        
        data = StreamSupport.stream(results.spliterator(), false).collect(Collectors.toList());
        
        return data;

    }
	
}

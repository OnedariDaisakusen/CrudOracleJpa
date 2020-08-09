package com.rest.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        
        ResultSet rs = (ResultSet) storedProcedureQuery.getOutputParameterValue("PO_CURSOR_USUARIO");
        
        try {
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNombreDdi(rs.getString("DDI"));
				u.setIdUser(rs.getInt("ID"));
				u.setUsername(rs.getString("USERNAME"));
				u.setNombre(rs.getString("USUARIO"));
				u.setIdDddi(rs.getInt("IDE_DDI"));
				u.setCodDdi(rs.getString("COD_DDI"));
				u.setEmail(rs.getString("EMAIL"));
				u.setCargo(rs.getString("CARGO"));
				u.setFlgActivo(rs.getInt("FLG_ACTIVO"));
				u.setFlgReporteStock(rs.getString("FLG_REPORTE_STOCK"));
				
				data.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
        
        //data = StreamSupport.stream(results.spliterator(), false).collect(Collectors.toList());
        
        return data;

    }

    public Usuario registrar(Usuario usuario) {
    	try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("SINPAD.BAH_PKG_ADMINISTRACION.USP_INS_UPD_USUARIO");
            
            storedProcedureQuery.registerStoredProcedureParameter("PI_ID_USER", Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_USERNAME", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_PASSWORD", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_CARGO", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_EMAIL", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_NOMBRE_USUARIO", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_FLG_ACTIVO", Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_IDE_DDI", Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_CONTROL", String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("PI_FLG_REPORTE_STOCK", String.class, ParameterMode.IN);

            storedProcedureQuery.registerStoredProcedureParameter("PO_ID_USER", Integer.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter("PO_CODIGO_RESPUESTA", String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter("PO_MENSAJE_RESPUESTA", String.class, ParameterMode.OUT);

            storedProcedureQuery.setParameter("PI_ID_USER", usuario.getIdUser());
            storedProcedureQuery.setParameter("PI_USERNAME", usuario.getUsername());
            storedProcedureQuery.setParameter("PI_PASSWORD", usuario.getPassword());
            storedProcedureQuery.setParameter("PI_CARGO", usuario.getCargo());
            storedProcedureQuery.setParameter("PI_EMAIL", usuario.getEmail());
            storedProcedureQuery.setParameter("PI_NOMBRE_USUARIO", usuario.getNombre());
            storedProcedureQuery.setParameter("PI_FLG_ACTIVO", usuario.getFlgActivo());
            storedProcedureQuery.setParameter("PI_IDE_DDI", usuario.getIdDddi());
            storedProcedureQuery.setParameter("PI_CONTROL", usuario.getControl());
            storedProcedureQuery.setParameter("PI_FLG_REPORTE_STOCK", usuario.getFlgReporteStock());

            storedProcedureQuery.execute();
            
            //usuario.setIdUser((int)storedProcedureQuery.getOutputParameterValue("PO_ID_USER"));
            usuario.setCodigo_respuesta((String)storedProcedureQuery.getOutputParameterValue("PO_CODIGO_RESPUESTA"));
            usuario.setMensaje_respuesta((String)storedProcedureQuery.getOutputParameterValue("PO_MENSAJE_RESPUESTA"));


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	return usuario;
    }
}

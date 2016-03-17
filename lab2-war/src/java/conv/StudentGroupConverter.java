package conv;

import dao.GroupDAOLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import models.StudentGroup;

@FacesConverter(forClass = StudentGroup.class)
public class StudentGroupConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Context c;
        try {
            c = new InitialContext();
            GroupDAOLocal dao = (GroupDAOLocal) c.lookup("java:global/lab2/lab2-ejb/GroupDAO!dao.GroupDAOLocal");
            StudentGroup group = dao.getGroupById(Integer.parseInt(value));
            return group;
        } catch (NamingException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }

}

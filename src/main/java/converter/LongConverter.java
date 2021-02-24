package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("longConverter")
public class LongConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value.trim().equals("")) {
			return null;
		}

		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			return null;
		}

	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		return ((Long) value).toString();
	}

}

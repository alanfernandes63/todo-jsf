package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import controllers.PessoaControllerImp;
import interfaces.IPessoaController;
import model.Pessoa;

@FacesConverter(value = "pessoaConverter")
public class PessoaConverter implements Converter {

	private IPessoaController iPessoaController;

	public PessoaConverter() {
		super();
		iPessoaController = new PessoaControllerImp();
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value == null) {
			return null;
		}
		return iPessoaController.buscarPorId(Long.decode(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value == null) {
			return null;
		}
		Pessoa pessoa = (Pessoa) value;
		return pessoa.getId().toString();
	}

}

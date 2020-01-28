package sonatypechallenge.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import sonatypechallenge.converter.english.IntegerToEnglishWordsConverter;
import sonatypechallenge.validator.IntegerValidationException;
import sonatypechallenge.validator.IntegerValidator;

@Path("/englishconverter")
public class IntegerToWordsService {

	@GET
	@Path("/{numberToTransform}")
	public Response transformNumberToEnglishWord(@PathParam("numberToTransform") String number) {

		String numberInWords = null;
		IntegerValidator validator = new IntegerValidator();
		try {
			validator.checkNumberIsValidIntegerOrThrowValidationException(number);
		} catch (IntegerValidationException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
		IntegerToEnglishWordsConverter converter = new IntegerToEnglishWordsConverter();
		numberInWords = converter.transformIntoWords(Integer.parseInt(validator.sanitizeInputNumber(number)));

		return Response.status(Response.Status.OK).entity(numberInWords).build();
	}
	

}

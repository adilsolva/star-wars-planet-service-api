package br.com.incubie.api.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class FeignException implements ErrorDecoder {

  @Override
  public Exception decode(String feignDetail, Response feignResponse) {
    final HttpStatus httpStatus = HttpStatus.resolve(feignResponse.status());
    
    if (HttpStatus.NOT_FOUND.equals(httpStatus))
    	return new NotFoundException("DATA NOT FOUND");
    else
    	return new Exception("SWAPI INTEGRATION ERROR");
  }

}
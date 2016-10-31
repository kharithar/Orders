package io.arrow.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class OrdersNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4287937314572834554L;

		public OrdersNotFoundException(String message) {
			super(message);
		}
		
		public OrdersNotFoundException(String message, Throwable cause) {
			super(message,cause);
		}
	
}

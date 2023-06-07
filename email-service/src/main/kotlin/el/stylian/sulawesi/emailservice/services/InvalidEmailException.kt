package el.stylian.sulawesi.emailservice.services

import java.security.InvalidParameterException

class InvalidEmailException(msg: String?) : InvalidParameterException(msg) {
}
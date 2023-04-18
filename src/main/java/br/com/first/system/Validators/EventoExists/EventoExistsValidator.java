package br.com.first.system.Validators.EventoExists;

import br.com.first.system.Repositories.EventoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventoExistsValidator implements
ConstraintValidator<EventoExists, String> {

    final EventoRepository eventoRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return eventoRepository.findById(value).isPresent();
    }
    
}

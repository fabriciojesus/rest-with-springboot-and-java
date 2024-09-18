package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
    private static AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/math/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        // Convertendo String para Double
        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);
        
        // Verificando se a conversão foi bem-sucedida
        if (num1 == null || num2 == null) {
            return 0D; // Retorna 0 em caso de erro na conversão
        }
        
        return num1 + num2;
    }
    
    // Método para converter String em Double, tratando exceções
    private Double convertToDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null; // Retorna null se a conversão falhar
        }
    }
}

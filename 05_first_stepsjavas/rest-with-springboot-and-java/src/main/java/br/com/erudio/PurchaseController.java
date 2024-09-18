package br.com.erudio;

import com.example.purchase.model.Purchase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @PostMapping("/purchase")
    public ResponseEntity<String> createPurchase(@RequestBody Purchase purchase) {
        // Lógica para processar a compra (pode ser salvar no banco de dados ou processar a transação)
        // Aqui vamos apenas retornar uma mensagem de sucesso por simplicidade
        
        return new ResponseEntity<>("Compra realizada com sucesso!", HttpStatus.CREATED);
    }
}

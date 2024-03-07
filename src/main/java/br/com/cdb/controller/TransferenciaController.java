package br.com.cdb.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@GetMapping("/buscar/{numero}")
    public ResponseEntity<List<Transferencia>> buscarHistorico(@PathVariable int numero) {
        List<Transferencia> historico = transferenciaService.historico(numero);
        return new ResponseEntity<>(historico, HttpStatus.OK);
    }

    @GetMapping("/buscar-todas")
    public ResponseEntity<List<Transferencia>> buscarTodasTransferencias() {
        List<Transferencia> transferencias = transferenciaService.transferencias();
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }
}
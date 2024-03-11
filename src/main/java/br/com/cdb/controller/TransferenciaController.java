package br.com.cdb.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;
import br.com.cdb.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@GetMapping("/buscar/{numero}")
    public ResponseEntity<List<TransferenciaDto>> buscarHistorico(@PathVariable int numero) {
        List<TransferenciaDto> historico = new ArrayList<>();
        for(Transferencia t : transferenciaService.historico(numero)) {
        	TransferenciaDto transfDto = new TransferenciaDto();
			transfDto.setContaDestino(t.getPessoa2());
			transfDto.setContaOrigem(t.getPessoa1());
			transfDto.setId(t.getId());
			transfDto.setTipoTransferencia(t.getTipo());
			transfDto.setValor(t.getValor());
			historico.add(transfDto);
        }
        return new ResponseEntity<>(historico, HttpStatus.OK);
    }

    @GetMapping("/buscar-todas")
    public ResponseEntity<List<TransferenciaDto>> buscarTodasTransferencias() {
        List<TransferenciaDto> transferencias = new ArrayList<>();
        
        for(Transferencia t : transferenciaService.transferencias()) {
        	TransferenciaDto transfDto = new TransferenciaDto();
			transfDto.setContaOrigem(t.getPessoa1());
			transfDto.setContaDestino(t.getPessoa2());
			transfDto.setId(t.getId());
			transfDto.setTipoTransferencia(t.getTipo());
			transfDto.setValor(t.getValor());
			transferencias.add(transfDto);
		
        }
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }
}
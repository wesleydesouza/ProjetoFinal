package duarte.wesley.banda.controller;


import duarte.wesley.banda.model.BandaEntity;
import duarte.wesley.banda.repository.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicos")
public class BandaController {

    @Autowired
    private BandaRepository bandaRepository;



    @GetMapping
    public ResponseEntity<List<BandaEntity>> findAll (){
        return new ResponseEntity<List<BandaEntity>>(
                (List<BandaEntity>) this.bandaRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BandaEntity> findById(@PathVariable("id") long id) {
        if(this.bandaRepository.findById(id).isPresent()){
            return new ResponseEntity<BandaEntity>(
                    this.bandaRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<BandaEntity>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<BandaEntity> cadastrar (@RequestBody BandaEntity bandaEntity) {
        return new ResponseEntity<BandaEntity> (
                this.bandaRepository.save(bandaEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<BandaEntity> atualizar (@PathVariable("id") long id,
                                                        @RequestBody BandaEntity bandaEntity) throws Exception {

        if(id == 0 || !this.bandaRepository.existsById(id)){
            throw  new Exception("Código não encontrado!");

        }
        return new ResponseEntity<BandaEntity>(
                this.bandaRepository.save(bandaEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BandaEntity> deletar (@PathVariable("id") long id ){
        this.bandaRepository.deleteById(id);
        return new ResponseEntity<BandaEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}

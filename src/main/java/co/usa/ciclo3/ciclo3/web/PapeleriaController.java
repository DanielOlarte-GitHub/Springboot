package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.model.Papeleria;
import co.usa.ciclo3.ciclo3.service.PapeleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Papeleria")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PapeleriaController {

    @Autowired
    private PapeleriaService papeleriaService;

    @GetMapping("/all")
    public List<Papeleria> getPapelerias(){
        return papeleriaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Papeleria> getPapeleria(@PathVariable("id") int id){
        return papeleriaService.getPapeleria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria save(@RequestBody Papeleria p){

        return papeleriaService.save(p);
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria update(@RequestBody Papeleria p){

        return papeleriaService.update(p);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        papeleriaService.delete(id);
    }
}

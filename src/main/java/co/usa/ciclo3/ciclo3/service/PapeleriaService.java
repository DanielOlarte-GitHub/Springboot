package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Papeleria;
import co.usa.ciclo3.ciclo3.repository.PapeleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PapeleriaService {

    @Autowired
    private PapeleriaRepository papeleriaRepository;

    public List<Papeleria> getAll(){
        return papeleriaRepository.getAll();
    }

    public Optional<Papeleria> getPapeleria(int id){
        return papeleriaRepository.getPapeleria(id);
    }

    public Papeleria save(Papeleria p){
        if(p.getId()==null){
            return papeleriaRepository.save(p);
        }else{
            Optional<Papeleria> pAux = papeleriaRepository.getPapeleria(p.getId());
            if(!pAux.isPresent()){
                return papeleriaRepository.save(p);
            }else{
                return p;
            }
        }
    }
}

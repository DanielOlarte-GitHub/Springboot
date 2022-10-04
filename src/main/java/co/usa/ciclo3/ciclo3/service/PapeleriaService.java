package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Categoria;
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

    public Papeleria update(Papeleria p){
        if(p.getId()!=null){
            Optional<Papeleria> q = papeleriaRepository.getPapeleria(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }

                if(p.getCategoria()!=null){
                    q.get().setCategoria(p.getCategoria());
                }

                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }

                if(p.getPrice()!=null){
                    q.get().setPrice(p.getPrice());
                }

                papeleriaRepository.save(q.get());

                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
        Boolean flag = false;

        Optional<Papeleria> q = papeleriaRepository.getPapeleria(id);
        if(q.isPresent()){
            papeleriaRepository.delete(q.get());
            flag = true;
        }

        return flag;
    }

}

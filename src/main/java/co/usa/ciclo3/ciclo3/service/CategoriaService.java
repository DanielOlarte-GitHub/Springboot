package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){

        return categoriaRepository.getAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria c){
        if(c.getId()==null){
            return categoriaRepository.save(c);
        }else{
            Optional<Categoria> cAux = categoriaRepository.getCategoria(c.getId());
            if(!cAux.isPresent()){
                return categoriaRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Categoria update(Categoria c){
        if(c.getId()!=null){
            Optional<Categoria> q = categoriaRepository.getCategoria(c.getId());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                categoriaRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        Boolean flag = false;

        Optional<Categoria> q = categoriaRepository.getCategoria(id);
        if(q.isPresent()){
            categoriaRepository.delete(q.get());
            flag = true;
        }

        return flag;
    }
}

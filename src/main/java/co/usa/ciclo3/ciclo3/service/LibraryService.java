package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll(){
        return libraryRepository.getAll();
    }

    public Optional<Library> getLibrary(Integer id){
        return libraryRepository.getLibrary(id);
    }

    public Library save(Library library){
        if(library.getId() == null){
            return libraryRepository.save(library);
        }else{
            Optional<Library> libraryAux = libraryRepository.getLibrary(library.getId());
            if(libraryAux.isEmpty()){
                return libraryRepository.save(library);
            }else{
               return library;
            }
        }
    }
}

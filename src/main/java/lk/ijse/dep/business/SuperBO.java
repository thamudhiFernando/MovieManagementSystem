package lk.ijse.dep.business;

import java.util.List;

public interface SuperBO<T> {

    public void save(T dto)throws Exception;

    public void remove(Integer id) throws Exception;

    public List<T> getAlls() throws Exception;

    public T getById(Integer id)throws Exception;

}

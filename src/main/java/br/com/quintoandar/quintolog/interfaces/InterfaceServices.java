package br.com.quintoandar.quintolog.interfaces;

public interface InterfaceServices<T> {

    public void save(T object);
    public Object listAll();
    public Object listById(Long id);
    public void delete(Long id);

}

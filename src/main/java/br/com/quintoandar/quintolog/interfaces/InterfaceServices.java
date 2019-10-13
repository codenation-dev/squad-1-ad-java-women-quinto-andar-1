package br.com.quintoandar.quintolog.interfaces;

public interface InterfaceServices<T> {
	
	public void salvar(T object);
	public Object listarTodos();
	public Object listarPorId(Long id);
	public void deletar(Long id);

}

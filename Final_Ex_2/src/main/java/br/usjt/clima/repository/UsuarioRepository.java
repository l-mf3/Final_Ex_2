package br.usjt.clima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.clima.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findOneByLoginAndSenha(String login, String senha);
	
	/*@Query("select u from Usuario u join PessoaFisica p on u.cpf = p.cpf where corOlho = :corOlho and corCabelo = :corCabelo")
	public Usuario encontrePorCorOlhoCabelo(String corOlho, String corCabelo);
	
	public Usuario findOneByCorOlhoAndCorCabelo(String corOlho, String corCabelo);*/
}
